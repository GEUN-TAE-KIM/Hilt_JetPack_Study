package kr.rmsxo.domain.usecase.main.board

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.rmsxo.domain.model.Board

interface GetBoardsUseCase {

    suspend operator fun invoke():Result<Flow<PagingData<Board>>>
}