package net.kuro.recrafted.structure.block.connectedtextures.api.texture.data;

public enum ConnectingTextureLayout {

    /**
     * Allows for connections with direct as well as diagonal neighbors.
     */
    FULL,
    /**
     * Allows for connections with horizontal neighbors.
     */
    HORIZONTAL,
    /**
     * Allows for connections only with direct neighbors.
     */
    SIMPLE,
    /**
     * Allows for connections with vertical neighbors.
     */
    VERTICAL,
    /**
     * Allows for reduced connections with direct neighbors.
     */
    COMPACT
}
