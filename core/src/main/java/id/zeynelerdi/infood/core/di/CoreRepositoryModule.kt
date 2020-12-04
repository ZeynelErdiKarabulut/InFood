package id.zeynelerdi.infood.core.di

import dagger.Binds
import dagger.Module
import id.zeynelerdi.infood.core.data.InFoodRepository
import id.zeynelerdi.infood.core.domain.repository.ICoreRepository

@Module(includes = [CoreNetworkModule::class, CoreDatabaseModule::class])
abstract class CoreRepositoryModule {

    @Binds
    abstract fun provideRepository(repository: InFoodRepository): ICoreRepository
}