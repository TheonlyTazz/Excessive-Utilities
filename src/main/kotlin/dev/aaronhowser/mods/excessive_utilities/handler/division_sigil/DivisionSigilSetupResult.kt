package dev.aaronhowser.mods.excessive_utilities.handler.division_sigil

import net.minecraft.network.chat.Component

sealed interface DivisionSigilSetupResult {

	val messages: List<Component>

	data class Ready(
		override val messages: List<Component>
	) : DivisionSigilSetupResult

	data class Invalid(
		override val messages: List<Component>
	) : DivisionSigilSetupResult

}