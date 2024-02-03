package net.kuro.recrafted.structure.block.connectedtextures.texture.types.scrolling;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.stream.IntStream;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpriteCreationContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.SpritePreparationContext;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.TextureType;
import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ScrollingTextureData;
import net.kuro.recrafted.structure.block.connectedtextures.api.util.Pair;
import net.minecraft.client.texture.Animator;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteContents;
import net.minecraft.client.texture.SpriteDimensions;
import net.minecraft.resource.metadata.ResourceMetadata;

public class ScrollingTextureType implements TextureType<ScrollingTextureData> {

    @Override
    public ScrollingTextureData deserialize(JsonObject json) throws JsonParseException{
        ScrollingTextureData.Builder builder = ScrollingTextureData.builder();
        if(json.has("from")){
            if(!json.get("from").isJsonPrimitive() || !json.getAsJsonPrimitive("from").isString())
                throw new JsonParseException("Property 'from' must be a string!");
            String fromString = json.get("from").getAsString();
            ScrollingTextureData.Position from;
            try{
                from = ScrollingTextureData.Position.valueOf(fromString.toUpperCase(Locale.ROOT));
            }catch(IllegalArgumentException e){
                throw new JsonParseException("Property 'from' must be one of " + Arrays.toString(ScrollingTextureData.Position.values()).toLowerCase(Locale.ROOT) + ", not '" + fromString + "'!");
            }
            builder.startPosition(from);
        }
        if(json.has("to")){
            if(!json.get("to").isJsonPrimitive() || !json.getAsJsonPrimitive("to").isString())
                throw new JsonParseException("Property 'to' must be a string!");
            String toString = json.get("to").getAsString();
            ScrollingTextureData.Position to;
            try{
                to = ScrollingTextureData.Position.valueOf(toString.toUpperCase(Locale.ROOT));
            }catch(IllegalArgumentException e){
                throw new JsonParseException("Property 'to' must be one of " + Arrays.toString(ScrollingTextureData.Position.values()).toLowerCase(Locale.ROOT) + ", not '" + toString + "'!");
            }
            builder.endPosition(to);
        }
        if(json.has("frame_time")){
            if(!json.get("frame_time").isJsonPrimitive() || !json.getAsJsonPrimitive("frame_time").isNumber())
                throw new JsonParseException("Property 'frame_time' must be an integer!");
            int frameTime = json.get("frame_time").getAsNumber().intValue();
            if(frameTime <= 0)
                throw new JsonParseException("Property 'frame_time' must have a value greater than 0!");
            builder.frameTime(frameTime);
        }
        if(json.has("frame_width")){
            if(!json.get("frame_width").isJsonPrimitive() || !json.getAsJsonPrimitive("frame_width").isNumber())
                throw new JsonParseException("Property 'frame_width' must be an integer!");
            int frameWidth = json.get("frame_width").getAsNumber().intValue();
            if(frameWidth <= 0)
                throw new JsonParseException("Property 'frame_width' must have a value greater than 0!");
            builder.frameWidth(frameWidth);
        }
        if(json.has("frame_height")){
            if(!json.get("frame_height").isJsonPrimitive() || !json.getAsJsonPrimitive("frame_height").isNumber())
                throw new JsonParseException("Property 'frame_height' must be an integer!");
            int frameHeight = json.get("frame_height").getAsNumber().intValue();
            if(frameHeight <= 0)
                throw new JsonParseException("Property 'frame_height' must have a value greater than 0!");
            builder.frameHeight(frameHeight);
        }
        if(json.has("loop_type")){
            if(!json.get("loop_type").isJsonPrimitive() || !json.getAsJsonPrimitive("loop_type").isString())
                throw new JsonParseException("Property 'loop_type' must be a string!");
            String loopTypeString = json.get("loop_type").getAsString();
            ScrollingTextureData.LoopType loopType;
            try{
                loopType = ScrollingTextureData.LoopType.valueOf(loopTypeString.toUpperCase(Locale.ROOT));
            }catch(IllegalArgumentException e){
                throw new JsonParseException("Property 'loop_type' must be one of " + Arrays.toString(ScrollingTextureData.LoopType.values()).toLowerCase(Locale.ROOT) + ", not '" + loopTypeString + "'!");
            }
            builder.loopType(loopType);
        }
        if(json.has("loop_pause")){
            if(!json.get("loop_pause").isJsonPrimitive() || !json.getAsJsonPrimitive("loop_pause").isNumber())
                throw new JsonParseException("Property 'loop_pause' must be an integer!");
            int loopPause = json.get("loop_pause").getAsNumber().intValue();
            if(loopPause < 0)
                throw new JsonParseException("Property 'loop_pause' must have a positive value!");
            builder.loopPause(loopPause);
        }
        return builder.build();
    }

    @Override
    public JsonObject serialize(ScrollingTextureData data){
        JsonObject json = new JsonObject();
        if(data.getStartPosition() != ScrollingTextureData.Position.TOP_LEFT)
            json.addProperty("from", data.getStartPosition().name().toLowerCase(Locale.ROOT));
        if(data.getEndPosition() != ScrollingTextureData.Position.BOTTOM_LEFT)
            json.addProperty("to", data.getEndPosition().name().toLowerCase(Locale.ROOT));
        if(data.getFrameTime() != 10)
            json.addProperty("frame_time", data.getFrameTime());
        if(data.getFrameWidth() != 16)
            json.addProperty("frame_width", data.getFrameWidth());
        if(data.getFrameHeight() != 16)
            json.addProperty("frame_height", data.getFrameHeight());
        if(data.getLoopType() != ScrollingTextureData.LoopType.RESET)
            json.addProperty("loop_type", data.getLoopType().name().toLowerCase(Locale.ROOT));
        if(data.getLoopPause() != 0)
            json.addProperty("loop_pause", data.getLoopPause());
        return json;
    }

    @Override
    public Pair<Integer,Integer> getFrameSize(SpritePreparationContext context, ScrollingTextureData data){
        if(context.getTextureWidth() < data.getFrameWidth() || context.getTextureHeight() < data.getFrameHeight())
            throw new RuntimeException("Frame size must be smaller than the texture size!");
        return Pair.of(data.getFrameWidth(), data.getFrameHeight());
    }

    @Override
    public Sprite createSprite(SpriteCreationContext context, ScrollingTextureData data){
        // Calculate frame start and end
        boolean reverse = data.getLoopType() == ScrollingTextureData.LoopType.REVERSE;
        int startX = data.getStartPosition() == ScrollingTextureData.Position.TOP_LEFT || data.getStartPosition() == ScrollingTextureData.Position.BOTTOM_LEFT ? 0 : context.getTextureWidth() - data.getFrameWidth();
        int startY = data.getStartPosition() == ScrollingTextureData.Position.TOP_LEFT || data.getStartPosition() == ScrollingTextureData.Position.TOP_RIGHT ? 0 : context.getTextureHeight() - data.getFrameHeight();
        int endX = data.getEndPosition() == ScrollingTextureData.Position.TOP_LEFT || data.getEndPosition() == ScrollingTextureData.Position.BOTTOM_LEFT ? 0 : context.getTextureWidth() - data.getFrameWidth();
        int endY = data.getEndPosition() == ScrollingTextureData.Position.TOP_LEFT || data.getEndPosition() == ScrollingTextureData.Position.TOP_RIGHT ? 0 : context.getTextureHeight() - data.getFrameHeight();

        // Calculate all the frames
        int stepCount = Math.max(Math.abs(endX - startX), Math.abs(endY - startY)) + 1;
        int frameCount = reverse ? Math.max((stepCount - 1) * 2, 1) : stepCount;
        int[] xPositions = new int[frameCount];
        int[] yPositions = new int[frameCount];
        int[] frameTimes = new int[frameCount];
        for(int index = 0; index < stepCount; index++){
            float percentage = stepCount > 1 ? (float)index / (stepCount - 1) : 0.5f;
            xPositions[index] = Math.round(startX + (endX - startX) * percentage);
            yPositions[index] = Math.round(startY + (endY - startY) * percentage);
            frameTimes[index] = data.getFrameTime();
        }
        frameTimes[stepCount - 1] += data.getLoopPause();
        if(reverse){
            for(int index = 1; index < stepCount - 1; index++){
                float percentage = 1 - (float)index / (stepCount - 1);
                xPositions[index + stepCount - 1] = Math.round(startX + (endX - startX) * percentage);
                yPositions[index + stepCount - 1] = Math.round(startY + (endY - startY) * percentage);
                frameTimes[index + stepCount - 1] = data.getFrameTime();
            }
            frameTimes[0] += data.getLoopPause();
        }

        // Finally create the new sprite
        ScrollingSpriteContents contents = new ScrollingSpriteContents(context.createOriginalSprite().getContents(), xPositions, yPositions, frameTimes);
        return new Sprite(
                context.getTextureIdentifier(),
                contents,
                context.getAtlasWidth(),
                context.getAtlasHeight(),
                context.getSpritePositionX(),
                context.getSpritePositionY()
        );
    }

    private static class ScrollingSpriteContents extends SpriteContents {

        private final int[] xPositions, yPositions;
        private final int[] frameTimes;
        private int frame, tickCounter;

        public ScrollingSpriteContents(SpriteContents original, int[] xPositions, int[] yPositions, int[] frameTimes){
            super(original.getId(), new SpriteDimensions(original.getWidth(), original.getHeight()), original.image, ResourceMetadata.NONE);
            this.xPositions = xPositions;
            this.yPositions = yPositions;
            this.frameTimes = frameTimes;
            this.mipmapLevelsImages = original.mipmapLevelsImages;
            this.animation = new ScrollingAnimatedTexture();
        }

        private void tick(int x, int y){
            if(++this.tickCounter >= this.frameTimes[this.frame]){
                this.frame = (this.frame + 1) % this.xPositions.length;
                this.tickCounter = 0;
                this.uploadFrame(x, y, this.frame);
            }
        }

        private void uploadFrame(int x, int y, int frame){
            this.upload(x, y, this.xPositions[frame], this.yPositions[frame], this.mipmapLevelsImages);
        }

        @Override
        public IntStream getDistinctFrameCount(){
            return IntStream.of(1);
        }

        private class ScrollingAnimatedTexture extends SpriteContents.Animation {

            public ScrollingAnimatedTexture(){
                super(Collections.emptyList(), 1, false);
            }

            @Override
            public Animator createAnimator(){
                return new Animator() {
                    @Override
                    public void tick(int x, int y){
                        ScrollingSpriteContents.this.tick(x, y);
                    }

                    @Override
                    public void close(){
                    }
                };
            }

            @Override
            public void upload(int x, int y){
                ScrollingSpriteContents.this.uploadFrame(x, y, 0);
            }

            @Override
            public IntStream getDistinctFrameCount(){
                return ScrollingSpriteContents.this.getDistinctFrameCount();
            }
        }
    }
}
