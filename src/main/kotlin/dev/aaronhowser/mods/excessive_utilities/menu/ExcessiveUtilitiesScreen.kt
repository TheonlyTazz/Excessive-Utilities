package dev.aaronhowser.mods.excessive_utilities.menu

import dev.aaronhowser.mods.aaron.menu.BaseScreen
import dev.aaronhowser.mods.excessive_utilities.menu.base.components.TexturedLabel
import dev.aaronhowser.mods.excessive_utilities.ExcessiveUtilities
import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.network.chat.Component
import net.minecraft.resources.Identifier
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.inventory.AbstractContainerMenu
import dev.aaronhowser.mods.aaron.menu.textures.ScreenBackground

abstract class ExcessiveUtilitiesScreen<M : AbstractContainerMenu>(
	menu: M,
	playerInventory: Inventory,
	title: Component,
	background: ScreenBackground
) : BaseScreen<M>(menu, playerInventory, title, background) {

	override val titleLabelOffsetX: Int = 4
	override val titleLabelOffsetY: Int = 4

	override val inventoryLabelOffsetY: Int = -5
	override val inventoryLabelOffsetX: Int = -4

	protected open val titleLabelSprite: Identifier = PLAIN_LABEL

	override fun baseInit() {
		super.baseInit()

		if (showTitleLabel) {
			val titleLabel = TexturedLabel(
				x = leftPos + titleLabelOffsetX,
				y = topPos + titleLabelOffsetY,
				font = font,
				messageGetter = { title },
				backgroundSprite = titleLabelSprite,
				textColor = LABEL_TEXT_COLOR,
				verticalPadding = 2,
				horizontalPadding = 3
			)

			addRenderableWidget(titleLabel)
		}

		if (showInventoryLabel) {
			val inventoryLabel = TexturedLabel(
				x = leftPos + inventoryLabelX + inventoryLabelOffsetX,
				y = topPos + inventoryLabelY + inventoryLabelOffsetY,
				font = font,
				messageGetter = { playerInventoryTitle },
				backgroundSprite = INVENTORY_LABEL,
				textColor = LABEL_TEXT_COLOR,
				verticalPadding = 2,
				horizontalPadding = 3
			)

			addRenderableWidget(inventoryLabel)
		}
	}

	companion object {
		const val LABEL_TEXT_COLOR: Int = 4210752

		val BLUE_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/blue")
		val BRIGHT_TEAL_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/bright_teal")
		val DARK_RED_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/dark_red")
		val PLAIN_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/plain")
		val RED_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/red")
		val TEAL_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/teal")
		val YELLOW_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/yellow")
		val INVENTORY_LABEL: Identifier =
			ExcessiveUtilities.modResource("label/inventory")
	}

}
