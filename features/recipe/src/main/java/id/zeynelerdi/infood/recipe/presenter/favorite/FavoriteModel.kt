package id.zeynelerdi.infood.recipe.presenter.favorite

import id.zeynelerdi.infood.core.domain.model.FoodCategory

data class FavoriteModel(
    val query: String?,
    val filterFoodCategories: List<FoodCategory>?
)