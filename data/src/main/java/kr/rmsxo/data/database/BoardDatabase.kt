package kr.rmsxo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.rmsxo.data.model.BoardDTO

@Database(
    entities = [BoardDTO::class, RemoteKey::class],
    version = 1
)
@TypeConverters(CommentConverter::class)
abstract class BoardDatabase : RoomDatabase(){
    abstract fun boardDao():BoardDao

    abstract fun remoteKeyDao():RemoteKeyDao

}