package kr.rmsxo.domain.usecase.main.board

interface DeleteBoardUseCase {

    suspend operator fun invoke(
        boardId:Long
    ):Result<Long>
}