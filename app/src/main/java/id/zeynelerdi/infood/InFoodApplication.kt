package id.zeynelerdi.infood

import android.app.Application
import id.zeynelerdi.infood.core.di.CoreComponent
import id.zeynelerdi.infood.core.di.DaggerCoreComponent

class InFoodApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: Application

        val coreComponent: CoreComponent by lazy {
            DaggerCoreComponent.factory().create(instance)
        }
    }
}