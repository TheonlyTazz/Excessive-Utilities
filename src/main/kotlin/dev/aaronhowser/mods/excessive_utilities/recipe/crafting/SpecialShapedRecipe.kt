package dev.aaronhowser.mods.excessive_utilities.recipe.crafting

import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.*
import net.minecraft.world.level.Level

/** Shared shape matching for the special crafting recipes. */
abstract class SpecialShapedRecipe(
    private val shape: ShapedRecipePattern,
    private val resultStack: ItemStack
) : CraftingRecipe {
    override fun matches(input: CraftingInput, level: Level): Boolean = shape.matches(input)
    override fun assemble(input: CraftingInput): ItemStack = resultStack.copy()
    override fun showNotification(): Boolean = false
    override fun group(): String = ""
    override fun category(): CraftingBookCategory = CraftingBookCategory.MISC
    override fun placementInfo(): PlacementInfo = PlacementInfo.createFromOptionals(shape.ingredients())
    fun getWidth(): Int = shape.width()
    fun getHeight(): Int = shape.height()
    fun getIngredients(): List<java.util.Optional<Ingredient>> = shape.ingredients()
}
