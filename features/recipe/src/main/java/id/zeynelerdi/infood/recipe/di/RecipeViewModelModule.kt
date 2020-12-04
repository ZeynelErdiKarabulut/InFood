package id.zeynelerdi.infood.recipe.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.zeynelerdi.infood.core.di.ViewModelKey
import id.zeynelerdi.infood.core.util.ViewModelFactory
import id.zeynelerdi.infood.recipe.presenter.detail.RecipeDetailViewModel
import id.zeynelerdi.infood.recipe.presenter.favorite.FavoriteViewModel
import id.zeynelerdi.infood.recipe.presenter.filter.RecipeFilterViewModel
import id.zeynelerdi.infood.recipe.presenter.list.RecipeListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
@Suppress("unused")
@Module
abstract class RecipeViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RecipeListViewModel::class)
    abstract fun bindRecipeListViewModel(recipeListViewModel: RecipeListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecipeFilterViewModel::class)
    abstract fun bindRecipeFilterViewModel(recipeFilterViewModel: RecipeFilterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailViewModel::class)
    abstract fun bindRecipeDetailViewModel(recipeDetailViewModel: RecipeDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(favoriteViewModel: FavoriteViewModel): ViewModel
}