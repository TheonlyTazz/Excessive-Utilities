package dev.aaronhowser.mods.excessive_utilities.menu.base.components

import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.gui.Font
import net.minecraft.client.gui.components.AbstractWidget
import net.minecraft.client.gui.narration.NarrationElementOutput
import net.minecraft.client.renderer.RenderPipelines
import net.minecraft.network.chat.Component
import net.minecraft.resources.Identifier

class TexturedLabel(
    x: Int, y: Int, private val font: Font, private val messageGetter: () -> Component,
    private val backgroundSprite: Identifier, private val textColor: Int,
    private val verticalPadding: Int, private val horizontalPadding: Int
) : AbstractWidget(x, y, 0, 0, Component.empty()) {
    override fun extractWidgetRenderState(guiGraphics: GuiGraphicsExtractor, mouseX: Int, mouseY: Int, partialTick: Float) {
        val message = messageGetter()
        val width = font.width(message) + horizontalPadding * 2
        val height = font.lineHeight + verticalPadding * 2
        setWidth(width)
        setHeight(height)
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, backgroundSprite, x, y, width, height)
        guiGraphics.text(font, message, x + horizontalPadding, y + verticalPadding, textColor)
    }
    override fun updateWidgetNarration(output: NarrationElementOutput) = defaultButtonNarrationText(output)
}
