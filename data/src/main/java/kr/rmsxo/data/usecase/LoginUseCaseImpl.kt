package kr.rmsxo.data.usecase

import kr.rmsxo.data.model.LoginParam
import kr.rmsxo.data.retrofit.UserService
import kr.rmsxo.domain.usecase.login.LoginUseCase
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val userService: UserService
) : LoginUseCase {

    override suspend fun invoke(id: String, password: String): Result<String> = kotlin.runCatching {

        val requestBody = LoginParam(loginId = id, password = password).toRequestBody()
        userService.login(requestBody = requestBody).data
    }
}