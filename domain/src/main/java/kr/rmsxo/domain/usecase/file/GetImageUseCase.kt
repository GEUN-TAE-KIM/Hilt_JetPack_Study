package kr.rmsxo.domain.usecase.file

import kr.rmsxo.domain.model.Image

interface GetImageUseCase {

    operator fun invoke(contentUri: String): Image?
}