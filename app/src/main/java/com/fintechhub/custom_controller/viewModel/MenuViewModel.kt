package com.fintechhub.custom_controller.viewModel
import com.fintechhub.custom_controller.di.AppMenuItem
import com.fintechhub.custom_controller.repository.AppController
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuRepository: AppController
) : ViewModel() {

    private val _appMenus = MutableLiveData<List<AppMenuItem>>()
    val appMenus: LiveData<List<AppMenuItem>> get() = _appMenus

    fun loadAppMenus(context: Context) {
        _appMenus.value = menuRepository.getAppMenus(context)
    }
}
