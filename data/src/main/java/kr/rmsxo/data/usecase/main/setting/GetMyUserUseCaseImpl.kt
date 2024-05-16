package kr.rmsxo.data.usecase.main.setting

import kr.rmsxo.data.model.toDomainModel
import kr.rmsxo.data.retrofit.UserService
import kr.rmsxo.domain.model.User
import kr.rmsxo.domain.usecase.main.setting.GetMyUserUseCase
import javax.inject.Inject

class GetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService
) : GetMyUserUseCase {

    override suspend fun invoke(): Result<User> = kotlin.runCatching {
        userService.getMyPage().data.toDomainModel()
    }
}