package kr.rmsxo.data.usecase.main.setting

import kr.rmsxo.data.model.UpdateMyInfoParam
import kr.rmsxo.data.retrofit.UserService
import kr.rmsxo.domain.usecase.main.setting.GetMyUserUseCase
import kr.rmsxo.domain.usecase.main.setting.SetMyUserUseCase
import javax.inject.Inject

class SetMyUserUseCaseImpl @Inject constructor(
    private val userService: UserService,
    private val getMyUserUseCase: GetMyUserUseCase
) : SetMyUserUseCase {
    override suspend fun invoke(
        username: String?,
        profileImageUrl:String?
    ): Result<Unit> = kotlin.runCatching{
        val user = getMyUserUseCase().getOrThrow()
        val requestBody = UpdateMyInfoParam(
            userName = username?:user.userName,
            profileFilePath = profileImageUrl?:user.profileImageUrl.orEmpty(),
            extraUserInfo = ""
        ).toRequestBody()
        userService.patchMyPage(requestBody)
    }
}