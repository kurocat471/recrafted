package net.kuro.recrafted.structure.block.connectedtextures.model.types.connecting;

import net.kuro.recrafted.structure.block.connectedtextures.api.predicate.ConnectionDirection;

public enum TextureRotation {

    _0(0), _90(1), _180(2), _270(3);

    private final int offset;

    TextureRotation(int offset){
        this.offset = offset * 2;
    }

    public ConnectionDirection rotate(ConnectionDirection direction){
        return ConnectionDirection.values()[(direction.ordinal() + this.offset) % 8];
    }
}
