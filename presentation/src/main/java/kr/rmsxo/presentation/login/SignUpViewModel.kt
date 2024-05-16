package kr.rmsxo.presentation.login

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kr.rmsxo.domain.usecase.login.SignUpUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel(),
    ContainerHost<SignUpState, SignUpSideEffect> {

    override val container: Container<SignUpState, SignUpSideEffect> = container(
        initialState = SignUpState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent { postSideEffect(SignUpSideEffect.Toast(throwable.message.orEmpty())) }
            }
        }
    )

    fun onIdChange(id: String) = blockingIntent {
        reduce { state.copy(id = id) }
    }

    fun onUserNameChange(userName: String) = blockingIntent {
        reduce { state.copy(userName = userName) }
    }

    fun onPassWordChange(passWord: String) = blockingIntent {
        reduce { state.copy(passWord = passWord) }
    }

    fun onRepeatPassWordChange(repeatPassWord: String) = blockingIntent {
        reduce { state.copy(repeatPassWord = repeatPassWord) }
    }

    fun onSignUpClick() = intent {
        if (state.passWord != state.repeatPassWord) {
            postSideEffect(SignUpSideEffect.Toast(message = "패스워드가 일치 하지 않음"))
            return@intent
        }
        val isSuccessful = signUpUseCase(
            id = state.id,
            username = state.userName,
            password = state.passWord,
        ).getOrThrow()

        if (isSuccessful) {
            postSideEffect(SignUpSideEffect.NavigateToLoginScreen)
            postSideEffect(SignUpSideEffect.Toast("회원가입 성공"))
        }
    }

}

@Immutable
data class SignUpState(
    val id: String = "",
    val userName: String = "",
    val passWord: String = "",
    val repeatPassWord: String = "",
)

sealed interface SignUpSideEffect {
    class Toast(val message: String) : SignUpSideEffect
    object NavigateToLoginScreen: SignUpSideEffect
}