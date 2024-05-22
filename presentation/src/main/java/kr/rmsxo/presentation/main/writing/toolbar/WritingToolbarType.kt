package kr.rmsxo.presentation.main.writing.toolbar

import androidx.annotation.DrawableRes
import kr.rmsxo.presentation.R

enum class WritingToolbarType(
    @DrawableRes val resId:Int,
){

    BOLD(R.drawable.bold),
    ITALIC(R.drawable.italic),
    UNDERLINE(R.drawable.underline),
    STRIKETHROUGH(R.drawable.strikethrough)
}