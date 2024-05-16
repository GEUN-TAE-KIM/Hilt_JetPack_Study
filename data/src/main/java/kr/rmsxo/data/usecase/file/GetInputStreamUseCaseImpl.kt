package kr.rmsxo.data.usecase.file

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import kr.rmsxo.domain.usecase.file.GetInputStreamUseCase
import java.io.InputStream
import java.lang.IllegalStateException
import javax.inject.Inject

class GetInputStreamUseCaseImpl @Inject constructor(
    private val context: Context,
) : GetInputStreamUseCase {

    @SuppressLint("Recycle")
    override fun invoke(contentUri: String): Result<InputStream> = kotlin.runCatching {
        val uri = Uri.parse(contentUri)
        context.contentResolver.openInputStream(uri) ?: throw IllegalStateException("실패")
    }
}