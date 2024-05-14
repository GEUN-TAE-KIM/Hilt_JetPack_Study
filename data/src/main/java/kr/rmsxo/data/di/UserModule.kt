package kr.rmsxo.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.rmsxo.data.usecase.ClearTokenUseCaseImpl
import kr.rmsxo.data.usecase.GetTokenUseCaseImpl
import kr.rmsxo.data.usecase.LoginUseCaseImpl
import kr.rmsxo.data.usecase.SetTokenUseCaseImpl
import kr.rmsxo.data.usecase.SignUpUseCaseImpl
import kr.rmsxo.domain.usecase.login.ClearTokenUseCase
import kr.rmsxo.domain.usecase.login.GetTokenUseCase
import kr.rmsxo.domain.usecase.login.LoginUseCase
import kr.rmsxo.domain.usecase.login.SetTokenUseCase
import kr.rmsxo.domain.usecase.login.SignUpUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(uc: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(uc: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    abstract fun bindGetTokenUseCase(uc: GetTokenUseCaseImpl): GetTokenUseCase

    @Binds
    abstract fun bindSetTokenUseCase(uc: SetTokenUseCaseImpl): SetTokenUseCase

    @Binds
    abstract fun bindClearTokenUseCase(uc: ClearTokenUseCaseImpl): ClearTokenUseCase
}