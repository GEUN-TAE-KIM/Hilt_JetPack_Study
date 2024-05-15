package kr.rmsxo.data.usecase

import kr.rmsxo.data.UserDataStore
import kr.rmsxo.domain.usecase.login.ClearTokenUseCase
import javax.inject.Inject

class ClearTokenUseCaseImpl @Inject constructor(
    private val userDataStore: UserDataStore,
) : ClearTokenUseCase {

    override suspend fun invoke(): Result<Unit> = kotlin.runCatching {
        userDataStore.clear()
    }
}