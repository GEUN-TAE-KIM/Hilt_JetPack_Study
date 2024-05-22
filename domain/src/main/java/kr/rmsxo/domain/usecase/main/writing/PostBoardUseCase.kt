package kr.rmsxo.domain.usecase.main.writing

import kr.rmsxo.domain.model.Image

interface PostBoardUseCase {

    suspend operator fun invoke(
        title: String,
        content: String,
        images: List<Image>
    )
}