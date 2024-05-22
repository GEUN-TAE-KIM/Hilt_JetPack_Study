package kr.rmsxo.domain.model

import java.io.Serializable

data class Image(
    val uri: String,
    val name: String,
    val size: Long,
    val mimeType: String
) : Serializable