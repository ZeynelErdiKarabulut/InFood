package id.zeynelerdi.infood.home.di

import dagger.Component
import id.zeynelerdi.infood.core.di.CoreComponent
import id.zeynelerdi.infood.home.presenter.HomeFragment

@HomeScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [HomeModule::class, HomeViewModelModule::class]
)
interface HomeComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): HomeComponent
    }

    fun inject(fragment: HomeFragment)
}