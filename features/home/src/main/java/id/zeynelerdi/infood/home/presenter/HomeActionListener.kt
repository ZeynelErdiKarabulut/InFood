package id.zeynelerdi.infood.home.presenter

import id.zeynelerdi.infood.core.domain.model.FoodCategory

interface HomeActionListener {

    fun onFoodCategoryClicked(foodCategory: FoodCategory)
}