package cat.rezelyn.watheextended.index;

import cat.rezelyn.watheextended.WatheExtended;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class WatheExtendedSounds {
    public static final SoundEvent GUIDEBOOK_OPEN = register("guidebook.open");
    public static final SoundEvent GUIDEBOOK_CLOSE = register("guidebook.close");
    public static final SoundEvent GUIDEBOOK_PAGE = register("guidebook.page");
    public static final SoundEvent ISH_PLUSH = register("ish.plush");

    private static SoundEvent register(String name) {
        ResourceLocation id = WatheExtended.id(name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }
    public static void initialize() {}
}
