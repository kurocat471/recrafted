package net.kuro.recrafted.structure.block.connectedtextures.api.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public interface Serializer<T> {

    /**
     * Deserializes the given json to some data.
     * @throws JsonParseException if the given json does not match the expected format
     */
    T deserialize(JsonObject json) throws JsonParseException;

    /**
     * Serializes the given data to json.
     */
    JsonObject serialize(T value);
}
