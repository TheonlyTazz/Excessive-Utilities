package dev.aaronhowser.mods.excessive_utilities.mixin;

import dev.aaronhowser.mods.excessive_utilities.datagen.tag.ModItemTagsProvider;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilMenu.class)
public class AnvilMenuMixin {

	@Redirect(
			method = "createResult",
			at = @At(
					value = "FIELD",
					target = "Lnet/minecraft/world/entity/player/Abilities;instabuild:Z",
					opcode = Opcodes.GETFIELD,
					ordinal = 1
			)
	)
	private boolean eu$disableTooExpensiveForTaggedItems(Abilities abilities) {
		AnvilMenu anvilMenu = (AnvilMenu) (Object) this;
		ItemStack inputStack = anvilMenu
				.getSlot(AnvilMenu.INPUT_SLOT)
				.getItem();

		return abilities.instabuild
				|| inputStack.is(ModItemTagsProvider.Companion.getINFINITE_ENCHANT_STACKING());
	}

}