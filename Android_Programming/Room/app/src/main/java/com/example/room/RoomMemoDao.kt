package com.example.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface RoomMemoDao {
    @Query("select * from room_memo")
    fun getAll(): List<RoomMemo>

    @Insert(onConflict = REPLACE) // 동일한 키를 가진 값이 입력되었을 때 Update 쿼리로 실행
    fun insert(memo: RoomMemo)

    @Delete
    fun delete(memo: RoomMemo)
}