package dev.aaronhowser.mods.excessive_utilities.client.render.entity

import net.minecraft.client.renderer.entity.state.EntityRenderState
import net.minecraft.client.renderer.item.ItemStackRenderState

class ItemEntityRenderState : EntityRenderState() {
	val item = ItemStackRenderState()
	var direction = net.minecraft.core.Direction.NORTH
	var rotation = 0f
	var yaw = 0f
}
