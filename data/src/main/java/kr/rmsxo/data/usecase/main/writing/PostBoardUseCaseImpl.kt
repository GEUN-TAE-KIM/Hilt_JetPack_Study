package kr.rmsxo.data.usecase.main.writing

import android.content.Context
import android.content.Intent
import kr.rmsxo.data.model.BoardParcel
import kr.rmsxo.data.service.PostingService
import kr.rmsxo.domain.model.Image
import kr.rmsxo.domain.usecase.main.writing.PostBoardUseCase
import javax.inject.Inject

class PostBoardUseCaseImpl @Inject constructor(
    private val context: Context
) : PostBoardUseCase {
    override suspend fun invoke(title: String, content: String, images: List<Image>) {
        val board = BoardParcel(title = title, content = content, images = images)
        context.startForegroundService(
            Intent(
                context,
                PostingService::class.java
            ).apply {
                putExtra(PostingService.EXTRA_BOARD, board)
            }
        )
    }


}