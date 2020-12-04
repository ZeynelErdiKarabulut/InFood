package id.zeynelerdi.infood.recipe.presenter.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.zeynelerdi.infood.core.domain.model.Ingredient
import id.zeynelerdi.infood.core.domain.model.Recipe
import id.zeynelerdi.infood.core.domain.model.Step
import id.zeynelerdi.infood.core.domain.usecase.CoreUseCase
import java.util.*
import javax.inject.Inject

class RecipeDetailViewModel @Inject constructor(private val useCase: CoreUseCase) : ViewModel() {

    private val _recipe = MutableLiveData<Recipe>()

    private val _isFavorite = Transformations.switchMap(_recipe) {
        useCase.isFavorite(it).asLiveData()
    }
    val isFavorite = Transformations.map(_isFavorite) { it }

    fun checkFavorite(recipe: Recipe) {
        _recipe.value = recipe
    }

    fun setFavorite(recipe: Recipe) {
        if (isFavorite.value?.data == true) {
            useCase.deleteFavorite(recipe)
        } else {
            useCase.insertFavorite(recipe)
        }

        _recipe.value = recipe
    }

    fun getFormattedSteps(steps: List<Step>): String {
        val stringBuilder = StringBuilder()

        steps.forEachIndexed { index, step ->
            if (index != steps.size - 1) {
                stringBuilder.append("${step.number}. ${step.step}")
                stringBuilder.append("\n")
            } else {
                stringBuilder.append("${step.number}. ${step.step}")
            }
        }

        return stringBuilder.toString()
    }

    fun getFormattedIngredients(ingredients: List<Ingredient>): String {
        val stringBuilder = StringBuilder()

        ingredients.forEachIndexed { index, ingredient ->
            if (index != ingredients.size - 1) {
                stringBuilder.append("- ${ingredient.name.capitalize(Locale.getDefault())}")
                stringBuilder.append("\n")
            } else {
                stringBuilder.append("- ${ingredient.name.capitalize(Locale.getDefault())}")
            }
        }

        return stringBuilder.toString()
    }
}