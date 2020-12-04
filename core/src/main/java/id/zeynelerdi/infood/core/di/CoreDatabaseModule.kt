package id.zeynelerdi.infood.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import id.zeynelerdi.infood.core.data.source.local.room.RecipeDao
import id.zeynelerdi.infood.core.data.source.local.room.FoodCategoryDao
import id.zeynelerdi.infood.core.data.source.local.room.InFoodDatabase
import javax.inject.Singleton

@Module
class CoreDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): InFoodDatabase =
        Room.databaseBuilder(
            context,
            InFoodDatabase::class.java, "InFood.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideFoodCategoryDao(database: InFoodDatabase): FoodCategoryDao = database.foodCategoryDao()

    @Provides
    fun provideFavoriteDao(database: InFoodDatabase): RecipeDao = database.favoriteDao()
}