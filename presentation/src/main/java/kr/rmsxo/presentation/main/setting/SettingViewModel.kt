package kr.rmsxo.presentation.main.setting

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kr.rmsxo.domain.model.User
import kr.rmsxo.domain.usecase.login.ClearTokenUseCase
import kr.rmsxo.domain.usecase.main.setting.GetMyUserUseCase
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val clearTokenUseCase: ClearTokenUseCase,
    private val getMyUserUseCase: GetMyUserUseCase
) : ViewModel(),
    ContainerHost<SettingState, SettingSideEffect> {

    override val container: Container<SettingState, SettingSideEffect> =
        container(
            initialState = SettingState(),
            buildSettings = {
                this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                    intent { postSideEffect(SettingSideEffect.Toast(throwable.message.orEmpty())) }
                }
            }
        )

    init {
        load()
    }

    private fun load() = intent {
        val user : User = getMyUserUseCase().getOrThrow()
        reduce {
            state.copy(
                profileImageUrl = user.profileImageUrl,
                userName = user.userName
            )
        }
    }

    fun onLogoutClick() = intent {
        clearTokenUseCase()
        postSideEffect(SettingSideEffect.NavigateToLoginActivity)
    }


}

data class SettingState(
    val profileImageUrl: String? = null,
    val userName: String = "",
)

sealed interface SettingSideEffect {
    class Toast(val message: String) : SettingSideEffect
    object NavigateToLoginActivity: SettingSideEffect
}