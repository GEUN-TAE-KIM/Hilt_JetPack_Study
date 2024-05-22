package kr.rmsxo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kr.rmsxo.domain.model.Image


@Parcelize
data class BoardParcel(
    val title: String,
    val content: String,
    val images: List<Image>
) : Parcelable