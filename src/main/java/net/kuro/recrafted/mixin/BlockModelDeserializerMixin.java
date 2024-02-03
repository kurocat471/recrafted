package net.kuro.recrafted.mixin;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.kuro.recrafted.structure.block.connectedtextures.api.model.ModelInstance;
import net.kuro.recrafted.structure.block.connectedtextures.model.ModelTypeRegistryImpl;
import net.kuro.recrafted.structure.block.connectedtextures.model.RecraftedBlockModel;
import net.kuro.recrafted.structure.block.connectedtextures.predicate.PredicateRegistryImpl;
import net.kuro.recrafted.structure.block.connectedtextures.util.IdentifierUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.lang.reflect.Type;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

@Mixin(value = JsonUnbakedModel.Deserializer.class, priority = 900)
public class BlockModelDeserializerMixin {

    @Unique
    private static final ThreadLocal<Boolean> SHOULD_IGNORE = ThreadLocal.withInitial(() -> false);

    @Inject(
            method = "deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/client/render/model/json/JsonUnbakedModel;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void deserialize(JsonElement json, Type type, JsonDeserializationContext context, CallbackInfoReturnable<JsonUnbakedModel> ci) throws JsonParseException{
        if(SHOULD_IGNORE.get())
            return;

        JsonElement loaderJson = json.getAsJsonObject().get("loader");
        if(loaderJson != null && loaderJson.isJsonPrimitive() && loaderJson.getAsJsonPrimitive().isString() && IdentifierUtil.isValidIdentifier(loaderJson.getAsString())){
            Identifier loader = new Identifier(loaderJson.getAsString());
            if(loader.getNamespace().equals("mc-recrafted") && loader.getPath().equals("model")){
                // Finalize model type registration
                ModelTypeRegistryImpl.finalizeRegistration();
                // Finalize predicate registration
                PredicateRegistryImpl.finalizeRegistration();

                // Load the model data
                SHOULD_IGNORE.set(true);
                ModelInstance<?> model = ModelTypeRegistryImpl.deserializeModelData(json.getAsJsonObject());
                SHOULD_IGNORE.set(false);

                // Create a dummy block model
                RecraftedBlockModel newModel = new RecraftedBlockModel(model);
                ci.setReturnValue(newModel);
            }
        }
    }
}