package com.beginner321.demo.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.ActionResult;

public interface DeadCallback {

        Event<DeadCallback> EVENT = EventFactory.createArrayBacked(DeadCallback.class,
                (listeners) -> (source) -> {
                    for (DeadCallback listener : listeners) {
                        ActionResult result = listener.interact(source);

                        if(result != ActionResult.PASS) {
                            return result;
                        }
                    }

                    return ActionResult.PASS;
                });

        ActionResult interact(DamageSource source);
}
