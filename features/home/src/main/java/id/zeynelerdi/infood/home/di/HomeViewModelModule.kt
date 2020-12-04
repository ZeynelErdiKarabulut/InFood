package id.zeynelerdi.infood.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.zeynelerdi.infood.core.di.ViewModelKey
import id.zeynelerdi.infood.core.util.ViewModelFactory
import id.zeynelerdi.infood.home.presenter.HomeViewModel

@Suppress("unused")
@Module
abstract class HomeViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}