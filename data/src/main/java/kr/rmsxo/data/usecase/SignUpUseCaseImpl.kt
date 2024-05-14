package kr.rmsxo.data.usecase

import kr.rmsxo.data.model.SignUpParam
import kr.rmsxo.data.retrofit.UserService
import kr.rmsxo.domain.usecase.login.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val userService: UserService
) : SignUpUseCase {

    override suspend fun invoke(id: String, username: String, password: String): Result<Boolean> =
        kotlin.runCatching {

            val requestBody = SignUpParam(
                loginId = id,
                name = username,
                password = password,
                extraUserInfo = "",
                profileFilePath = "",
            ).toRequestBody()

            userService.signUp(requestBody = requestBody).result == "SUCCESS"

        }

}