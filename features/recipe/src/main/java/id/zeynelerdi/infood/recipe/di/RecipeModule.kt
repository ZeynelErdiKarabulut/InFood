package id.zeynelerdi.infood.recipe.di

import dagger.Binds
import dagger.Module
import id.zeynelerdi.infood.core.domain.usecase.CoreUseCase
import id.zeynelerdi.infood.core.domain.usecase.ICoreUseCase

@Module
abstract class RecipeModule {

    @Binds
    abstract fun provideCoreUseCase(useCase: CoreUseCase): ICoreUseCase
}