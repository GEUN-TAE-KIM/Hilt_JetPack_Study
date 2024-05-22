package kr.rmsxo.domain.usecase.main.board

interface DeleteCommentUseCase {

    suspend operator fun invoke(
        boardId:Long,
        commentId:Long
    ):Result<Long>
}