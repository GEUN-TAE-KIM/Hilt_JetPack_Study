package kr.rmsxo.data.usecase.main.board

import kr.rmsxo.data.model.comment.CommentParam
import kr.rmsxo.data.retrofit.BoardService
import kr.rmsxo.domain.usecase.main.board.PostCommentUseCase
import javax.inject.Inject

class PostCommentUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : PostCommentUseCase {
    override suspend fun invoke(boardId: Long, text: String): Result<Long> = kotlin.runCatching {
        val requestBody = CommentParam(text).toRequestBody()
        boardService.postComment(
            boardId = boardId,
            requestBody = requestBody
        ).data
    }
}