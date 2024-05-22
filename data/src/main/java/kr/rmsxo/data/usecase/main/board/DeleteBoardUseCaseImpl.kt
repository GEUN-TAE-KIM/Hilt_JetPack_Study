package kr.rmsxo.data.usecase.main.board

import kr.rmsxo.data.retrofit.BoardService
import kr.rmsxo.domain.usecase.main.board.DeleteBoardUseCase
import javax.inject.Inject

class DeleteBoardUseCaseImpl @Inject constructor(
    private val boardService: BoardService
) : DeleteBoardUseCase {
    override suspend fun invoke(boardId: Long): Result<Long> = kotlin.runCatching {
        boardService.deleteBoard(boardId).data
    }
}