package kr.rmsxo.domain.usecase.file

import kr.rmsxo.domain.model.Image

interface UploadImageUseCase {
    suspend operator fun invoke(
        image: Image
    ): Result<String>
}