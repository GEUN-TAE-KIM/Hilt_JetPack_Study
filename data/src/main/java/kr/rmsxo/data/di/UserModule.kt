package kr.rmsxo.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.rmsxo.data.usecase.LoginUseCaseImpl
import kr.rmsxo.domain.usecase.login.LoginUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UserModule {

    @Binds
    abstract fun bindLoginUseCase(uc:LoginUseCaseImpl):LoginUseCase
}