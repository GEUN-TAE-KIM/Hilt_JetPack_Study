package kr.rmsxo.domain.model

data class User(
    val id: Long,
    val loginId: String,
    val userName: String,
    val profileImageUrl: String? = null,
)