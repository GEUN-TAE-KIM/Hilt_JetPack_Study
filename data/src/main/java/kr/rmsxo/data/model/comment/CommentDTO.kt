package kr.rmsxo.data.model.comment

import kotlinx.serialization.Serializable
import kr.rmsxo.domain.model.Comment

@Serializable
data class CommentDTO(
    val id: Long,
    val comment: String,
    val createdAt: String,
    val createUserId: Long,
    val createUserName: String,
    val profileImageUrl: String,
)

fun CommentDTO.toDomainModel(): Comment {
    return Comment(
        id = id,
        text = comment,
        username = createUserName,
        profileImageUrl = profileImageUrl
    )
}