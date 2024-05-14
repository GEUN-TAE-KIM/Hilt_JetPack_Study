package kr.rmsxo.data.usecase

import kr.rmsxo.data.UserDataStore
import kr.rmsxo.domain.usecase.login.SetTokenUseCase
import javax.inject.Inject

class SetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore,
) : SetTokenUseCase {

    override suspend fun invoke(token: String) {
        userDataStore.setToken(token)
    }
}