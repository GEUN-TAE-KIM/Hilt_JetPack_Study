package kr.rmsxo.data.usecase

import kr.rmsxo.data.UserDataStore
import kr.rmsxo.domain.usecase.login.GetTokenUseCase
import javax.inject.Inject

class GetTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : GetTokenUseCase {

    override suspend fun invoke(): String? {
        return userDataStore.getToken()
    }
}