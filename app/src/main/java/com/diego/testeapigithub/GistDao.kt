package com.diego.testeapigithub

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GistDao {
    @Query("SELECT * FROM gistdb")
    fun getAll() : List<GistDB>

    @Insert
    fun insertAll(vararg gist: GistDB)

    @Delete
    fun delete(gist:GistDB)
}