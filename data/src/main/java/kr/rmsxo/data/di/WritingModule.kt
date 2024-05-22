package kr.rmsxo.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kr.rmsxo.data.usecase.main.writing.GetImageListUseCaseImpl
import kr.rmsxo.data.usecase.main.writing.HiltWorkerPostBoardUseCase
import kr.rmsxo.domain.usecase.main.writing.GetImageListUseCase
import kr.rmsxo.domain.usecase.main.writing.PostBoardUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WritingModule {

    @Binds
    abstract fun bindGetImageListUseCase(uc: GetImageListUseCaseImpl): GetImageListUseCase

//    @Binds
//    abstract fun bindPostBoardUseCase(uc: PostBoardUseCaseImpl): PostBoardUseCase

    @Binds
    abstract fun bindPostBoardUseCase(uc: HiltWorkerPostBoardUseCase): PostBoardUseCase
}