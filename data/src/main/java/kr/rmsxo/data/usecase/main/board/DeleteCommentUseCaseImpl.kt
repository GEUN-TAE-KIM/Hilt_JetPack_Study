package kr.rmsxo.data.usecase.main.board

import kr.rmsxo.data.retrofit.BoardService
import kr.rmsxo.domain.usecase.main.board.DeleteCommentUseCase
import javax.inject.Inject

class DeleteCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteCommentUseCase {
    override suspend fun invoke(boardId: Long, commentId: Long): Result<Long> = kotlin.runCatching{
        boardService.deleteComment(
            boardId = boardId,
            commentId = commentId
        ).data
    }
}