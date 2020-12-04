package id.zeynelerdi.infood.home.di

import dagger.Binds
import dagger.Module
import id.zeynelerdi.infood.core.domain.usecase.CoreUseCase
import id.zeynelerdi.infood.core.domain.usecase.ICoreUseCase

@Module
abstract class HomeModule {

    @Binds
    abstract fun provideCoreUseCase(useCase: CoreUseCase): ICoreUseCase
}