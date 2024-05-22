package kr.rmsxo.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import kr.rmsxo.data.usecase.main.board.DeleteBoardUseCaseImpl
import kr.rmsxo.data.usecase.main.board.DeleteCommentUseCaseImpl
import kr.rmsxo.data.usecase.main.board.GetBoardsUseCaseImpl
import kr.rmsxo.data.usecase.main.board.PostCommentUseCaseImpl
import kr.rmsxo.domain.usecase.main.board.DeleteBoardUseCase
import kr.rmsxo.domain.usecase.main.board.DeleteCommentUseCase
import kr.rmsxo.domain.usecase.main.board.GetBoardsUseCase
import kr.rmsxo.domain.usecase.main.board.PostCommentUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class BoardModule {

    @Binds
    abstract fun bindGetBoardsUseCase(uc: GetBoardsUseCaseImpl): GetBoardsUseCase

    @Binds
    abstract fun bindDeleteBoardUseCase(uc: DeleteBoardUseCaseImpl): DeleteBoardUseCase

    @Binds
    abstract fun bindPostCommentUseCase(uc: PostCommentUseCaseImpl): PostCommentUseCase

    @Binds
    abstract fun bindDeleteCommentUseCase(uc: DeleteCommentUseCaseImpl): DeleteCommentUseCase
}