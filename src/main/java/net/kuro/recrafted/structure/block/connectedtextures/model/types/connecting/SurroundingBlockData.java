package net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting;

import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionDirection;
import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionPredicate;
import org.joml.Matrix4f;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AffineTransformation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;

public class SurroundingBlockData {

    private static final ThreadLocal<BlockPos.Mutable> MUTABLE_POS = ThreadLocal.withInitial(BlockPos.Mutable::new);

    public static SurroundingBlockData create(BlockRenderView level, BlockPos pos, AffineTransformation rotation, Map<Identifier, ConnectionPredicate> predicates){
        AffineTransformation inverseRotation = rotation.invert();
        Matrix4f rotationMatrix = inverseRotation == null ? AffineTransformation.identity().getMatrix() : rotation.getMatrix();
        Matrix4f inverseRotationMatrix = inverseRotation == null ? AffineTransformation.identity().getMatrix() : inverseRotation.getMatrix();
        // Collect all surrounding blocks
        BlockState[][][] states = new BlockState[3][3][3];
        BlockPos.Mutable neighborPos = MUTABLE_POS.get();
        for(int i = 0; i < 27; i++){
            neighborPos.set(pos.getX() + i % 3 - 1, pos.getY() + i / 3 % 3 - 1, pos.getZ() + i / 9 % 3 - 1);
            states[i % 3][i / 3 % 3][i / 9 % 3] = level.getBlockState(neighborPos);
        }
        // Test all the predicates
        ImmutableMap.Builder<Identifier,Map<Direction,SideConnections>> connectionsBuilder = ImmutableMap.builder();
        for(Identifier sprite : predicates.keySet()){
            Map<Direction,SideConnections> spriteConnections = new EnumMap<>(Direction.class);
            for(Direction side : Direction.values())
                spriteConnections.put(side, getConnections(side, rotationMatrix, inverseRotationMatrix, states, predicates.get(sprite), level, pos));
            connectionsBuilder.put(sprite, spriteConnections);
        }
        return new SurroundingBlockData(connectionsBuilder.build());
    }

    private static SideConnections getConnections(Direction side, Matrix4f rotation, Matrix4f inverseRotation, BlockState[][][] states, ConnectionPredicate predicate, BlockRenderView level, BlockPos pos){
        Direction originalSide = Direction.transform(inverseRotation, side);
        Direction left;
        Direction right;
        Direction up;
        Direction down;
        if(originalSide.getAxis() == Direction.Axis.Y){
            left = Direction.WEST;
            right = Direction.EAST;
            up = originalSide == Direction.UP ? Direction.NORTH : Direction.SOUTH;
            down = originalSide == Direction.UP ? Direction.SOUTH : Direction.NORTH;
        }else{
            left = originalSide.rotateYClockwise();
            right = originalSide.rotateYCounterclockwise();
            up = Direction.UP;
            down = Direction.DOWN;
        }
        left = Direction.transform(rotation, left);
        right = Direction.transform(rotation, right);
        up = Direction.transform(rotation, up);
        down = Direction.transform(rotation, down);

        BlockState self = states[1][1][1];
        boolean connectTop = shouldConnect(states, side, originalSide, self, up.getOffsetX(), up.getOffsetY(), up.getOffsetZ(), ConnectionDirection.TOP, predicate, level, pos);
        boolean connectTopRight = shouldConnect(states, side, originalSide, self, up.getOffsetX() + right.getOffsetX(), up.getOffsetY() + right.getOffsetY(), up.getOffsetZ() + right.getOffsetZ(), ConnectionDirection.TOP_RIGHT, predicate, level, pos);
        boolean connectRight = shouldConnect(states, side, originalSide, self, right.getOffsetX(), right.getOffsetY(), right.getOffsetZ(), ConnectionDirection.RIGHT, predicate, level, pos);
        boolean connectBottomRight = shouldConnect(states, side, originalSide, self, down.getOffsetX() + right.getOffsetX(), down.getOffsetY() + right.getOffsetY(), down.getOffsetZ() + right.getOffsetZ(), ConnectionDirection.BOTTOM_RIGHT, predicate, level, pos);
        boolean connectBottom = shouldConnect(states, side, originalSide, self, down.getOffsetX(), down.getOffsetY(), down.getOffsetZ(), ConnectionDirection.BOTTOM, predicate, level, pos);
        boolean connectBottomLeft = shouldConnect(states, side, originalSide, self, down.getOffsetX() + left.getOffsetX(), down.getOffsetY() + left.getOffsetY(), down.getOffsetZ() + left.getOffsetZ(), ConnectionDirection.BOTTOM_LEFT, predicate, level, pos);
        boolean connectLeft = shouldConnect(states, side, originalSide, self, left.getOffsetX(), left.getOffsetY(), left.getOffsetZ(), ConnectionDirection.LEFT, predicate, level, pos);
        boolean connectTopLeft = shouldConnect(states, side, originalSide, self, up.getOffsetX() + left.getOffsetX(), up.getOffsetY() + left.getOffsetY(), up.getOffsetZ() + left.getOffsetZ(), ConnectionDirection.TOP_LEFT, predicate, level, pos);
        return new SideConnections(side, connectTop, connectTopRight, connectRight, connectBottomRight, connectBottom, connectBottomLeft, connectLeft, connectTopLeft);
    }

    private static boolean shouldConnect(BlockState[][][] states, Direction side, Direction originalSide, BlockState self, int neighborX, int neighborY, int neighborZ, ConnectionDirection direction, ConnectionPredicate predicate, BlockRenderView level, BlockPos pos){
        BlockState otherState = states[neighborX + 1][neighborY + 1][neighborZ + 1];
        BlockPos.Mutable neighborPos = MUTABLE_POS.get();
        neighborPos.set(pos.getX() + neighborX, pos.getY() + neighborY, pos.getZ() + neighborZ);
        BlockState selfAppearance = self.getAppearance(level, pos, side, otherState, neighborPos);
        BlockState otherStateAppearance = otherState.getAppearance(level, neighborPos, side, self, pos);
        BlockState stateInFront = states[neighborX + 1 + side.getOffsetX()][neighborY + 1 + side.getOffsetY()][neighborZ + 1 + side.getOffsetZ()];
        return predicate.shouldConnect(originalSide, selfAppearance, otherStateAppearance, stateInFront, direction);
    }

    private final Map<Identifier,Map<Direction,SideConnections>> connections;
    private final int hashCode;

    private SurroundingBlockData(Map<Identifier,Map<Direction,SideConnections>> connections){
        this.connections = connections;
        // Calculate the hashcode once and store it
        this.hashCode = this.connections.hashCode();
    }

    public SideConnections getConnections(Identifier sprite, Direction side){
        return this.connections.getOrDefault(sprite, Collections.emptyMap()).get(side);
    }

    @Override
    public int hashCode(){
        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof SurroundingBlockData && this.hashCode == ((SurroundingBlockData)obj).hashCode;
    }

    public static final class SideConnections {

        public final Direction side;
        public final boolean top;
        public final boolean topRight;
        public final boolean right;
        public final boolean bottomRight;
        public final boolean bottom;
        public final boolean bottomLeft;
        public final boolean left;
        public final boolean topLeft;
        public final int hash;

        public SideConnections(Direction side, boolean top, boolean topRight, boolean right, boolean bottomRight, boolean bottom, boolean bottomLeft, boolean left, boolean topLeft){
            this.side = side;
            this.top = top;
            this.topRight = topRight;
            this.right = right;
            this.bottomRight = bottomRight;
            this.bottom = bottom;
            this.bottomLeft = bottomLeft;
            this.left = left;
            this.topLeft = topLeft;
            this.hash = Objects.hash(this.top, this.topRight, this.right, this.bottomRight, this.bottom, this.bottomLeft, this.left, this.topLeft);
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || this.getClass() != o.getClass()) return false;
            SideConnections that = (SideConnections)o;
            return this.left == that.left && this.right == that.right && this.top == that.top && this.topLeft == that.topLeft && this.topRight == that.topRight && this.bottom == that.bottom && this.bottomLeft == that.bottomLeft && this.bottomRight == that.bottomRight && this.side == that.side;
        }

        @Override
        public int hashCode(){
            return this.hash;
        }
    }
}
