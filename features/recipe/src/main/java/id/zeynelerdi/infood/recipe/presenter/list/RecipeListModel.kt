package id.zeynelerdi.infood.recipe.presenter.list

import id.zeynelerdi.infood.core.domain.model.FoodCategory

data class RecipeListModel(
    val query: String?,
    val filterFoodCategories: List<FoodCategory>?
)