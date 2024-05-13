package kr.rmsxo.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.rmsxo.domain.usecase.login.LoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    fun onLoginClick() {
        val id = ""
        val passWord = ""
        viewModelScope.launch {
            loginUseCase(id, passWord)
        }
    }
}