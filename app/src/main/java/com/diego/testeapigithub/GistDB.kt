package com.diego.testeapigithub

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GistDB(
    @PrimaryKey
    val user: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "link")
    val link: String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val avatar: ByteArray?
)