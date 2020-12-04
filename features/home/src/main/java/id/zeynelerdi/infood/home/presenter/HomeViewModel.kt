package id.zeynelerdi.infood.home.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.zeynelerdi.infood.core.domain.usecase.CoreUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(coreUseCase: CoreUseCase) : ViewModel() {

    val foodCategories = coreUseCase.getFoodCategories().asLiveData()
}