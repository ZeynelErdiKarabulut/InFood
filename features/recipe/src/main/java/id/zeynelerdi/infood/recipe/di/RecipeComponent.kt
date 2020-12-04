package id.zeynelerdi.infood.recipe.di

import dagger.Component
import id.zeynelerdi.infood.core.di.CoreComponent
import id.zeynelerdi.infood.recipe.presenter.detail.RecipeDetailFragment
import id.zeynelerdi.infood.recipe.presenter.favorite.FavoriteFragment
import id.zeynelerdi.infood.recipe.presenter.filter.RecipeFilterFragment
import id.zeynelerdi.infood.recipe.presenter.list.RecipeListFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@RecipeScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [RecipeModule::class, RecipeViewModelModule::class]
)
interface RecipeComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): RecipeComponent
    }

    fun inject(fragment: RecipeListFragment)

    fun inject(fragment: RecipeFilterFragment)

    fun inject(fragment: RecipeDetailFragment)

    fun inject(fragment: FavoriteFragment)
}