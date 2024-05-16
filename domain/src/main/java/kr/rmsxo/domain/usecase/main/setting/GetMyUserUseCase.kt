package kr.rmsxo.domain.usecase.main.setting

import kr.rmsxo.domain.model.User

interface GetMyUserUseCase {

    suspend operator fun invoke():Result<User>
}