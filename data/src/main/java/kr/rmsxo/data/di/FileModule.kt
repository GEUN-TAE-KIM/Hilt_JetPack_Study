package kr.rmsxo.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.rmsxo.data.usecase.file.GetImageUseCaseImpl
import kr.rmsxo.data.usecase.file.GetInputStreamUseCaseImpl
import kr.rmsxo.data.usecase.file.UploadImageUseCaseImpl
import kr.rmsxo.domain.usecase.file.GetImageUseCase
import kr.rmsxo.domain.usecase.file.GetInputStreamUseCase
import kr.rmsxo.domain.usecase.file.UploadImageUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class FileModule {
    @Binds
    abstract fun bindGetInputStreamUseCase(uc: GetInputStreamUseCaseImpl): GetInputStreamUseCase

    @Binds
    abstract fun bindGetImageUseCase(uc: GetImageUseCaseImpl): GetImageUseCase

    @Binds
    abstract fun bindUploadImageUseCase(uc: UploadImageUseCaseImpl): UploadImageUseCase
}