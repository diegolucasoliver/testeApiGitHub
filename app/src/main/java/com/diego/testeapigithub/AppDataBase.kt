package com.diego.testeapigithub

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(GistDB::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun gistDao(): GistDao
}