package dev.aaronhowser.mods.excessive_utilities.mixin;

import dev.aaronhowser.mods.excessive_utilities.datagen.tag.ModItemTagsProvider;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AnvilScreen.class)
public class AnvilScreenMixin {

	@Redirect(
			method = "renderLabels",
			at = @At(
					value = "FIELD",
					target = "Lnet/minecraft/world/entity/player/Abilities;instabuild:Z",
					opcode = Opcodes.GETFIELD
			)
	)
	private boolean eu$disableTooExpensiveForTaggedItems(Abilities abilities) {
		AnvilScreen anvilScreen = (AnvilScreen) (Object) this;
		ItemStack inputStack = anvilScreen
				.getMenu()
				.getSlot(AnvilMenu.INPUT_SLOT)
				.getItem();

		return abilities.instabuild
				|| inputStack.is(ModItemTagsProvider.Companion.getINFINITE_ENCHANT_STACKING());
	}

}