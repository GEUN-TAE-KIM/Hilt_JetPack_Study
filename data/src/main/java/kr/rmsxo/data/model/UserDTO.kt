package kr.rmsxo.data.model

import kotlinx.serialization.Serializable
import kr.rmsxo.domain.model.User

@Serializable
data class UserDTO(
    val id: Long,
    val loginId: String,
    val userName: String,
    val extraUserInfo: String,
    val profileFilePath: String,
)

fun UserDTO.toDomainModel(): User {
    return User(
        id = this.id,
        loginId = this.loginId,
        userName = this.userName,
        profileImageUrl = this.profileFilePath
    )
}