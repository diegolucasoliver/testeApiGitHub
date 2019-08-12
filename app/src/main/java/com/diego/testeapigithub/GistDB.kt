package com.diego.testeapigithub

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GistDB(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "user")
    val user: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val avatar: ByteArray?
)