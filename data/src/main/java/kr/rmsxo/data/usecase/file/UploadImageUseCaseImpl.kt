package kr.rmsxo.data.usecase.file

import kr.rmsxo.data.retrofit.FileService
import kr.rmsxo.data.retrofit.UriRequestBody
import kr.rmsxo.domain.model.Image
import kr.rmsxo.domain.usecase.file.GetInputStreamUseCase
import kr.rmsxo.domain.usecase.file.UploadImageUseCase
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadImageUseCaseImpl @Inject constructor(
    private val fileService: FileService,
    private val getInputStreamUseCase: GetInputStreamUseCase,
) : UploadImageUseCase {

    override suspend fun invoke(image: Image): Result<String> = kotlin.runCatching {
        val fileNamePart = MultipartBody.Part.createFormData(
            "fileName",
            image.name
        )
        val requestBody = UriRequestBody(
            contentUri = image.uri,
            getInputStreamUseCase = getInputStreamUseCase,
            contentType = image.mimeType.toMediaType(),
            contentLength = image.size
        )
        val filePart = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestBody
        )
        fileService.uploadFile(
            fileName = fileNamePart,
            file = filePart,
        ).data.filePath
    }
}