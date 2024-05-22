package kr.rmsxo.domain.usecase.main.writing

import kr.rmsxo.domain.model.Image

interface GetImageListUseCase {
    suspend operator fun invoke():List<Image>
}