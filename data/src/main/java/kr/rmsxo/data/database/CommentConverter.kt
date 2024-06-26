package kr.rmsxo.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kr.rmsxo.data.model.comment.CommentDTO

class CommentConverter {

    @TypeConverter
    fun fromCommentListToJson(commentList: List<CommentDTO>):String{
        return Json.encodeToString(commentList)
    }

    @TypeConverter
    fun fromJsonToCommentList(json:String):List<CommentDTO>{
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromCommentToJson(comment:CommentDTO):String{
        return Json.encodeToString(comment)
    }

    @TypeConverter
    fun fromJsonToComment(json:String):CommentDTO{
        return Json.decodeFromString(json)
    }
}