package net.kuro.recrafted.structure.block.connectedtextures.texture.types.scrolling;

import net.kuro.recrafted.structure.block.connectedtextures.api.texture.data.ScrollingTextureData;

public class ScrollingTextureDataImpl implements ScrollingTextureData {

    private final ScrollingTextureData.Position startPosition, endPosition;
    private final int frameTime, frameWidth, frameHeight;
    private final ScrollingTextureData.LoopType loopType;
    private final int loopPause;

    public ScrollingTextureDataImpl(Position startPosition, Position endPosition, int frameTime, int frameWidth, int frameHeight, LoopType loopType, int loopPause){
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.frameTime = frameTime;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.loopType = loopType;
        this.loopPause = loopPause;
    }

    @Override
    public ScrollingTextureData.Position getStartPosition(){
        return this.startPosition;
    }

    @Override
    public ScrollingTextureData.Position getEndPosition(){
        return this.endPosition;
    }

    @Override
    public int getFrameTime(){
        return this.frameTime;
    }

    @Override
    public int getFrameWidth(){
        return this.frameWidth;
    }

    @Override
    public int getFrameHeight(){
        return this.frameHeight;
    }

    @Override
    public ScrollingTextureData.LoopType getLoopType(){
        return this.loopType;
    }

    @Override
    public int getLoopPause(){
        return this.loopPause;
    }
}
