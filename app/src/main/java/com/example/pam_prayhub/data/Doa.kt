package com.example.pam_prayhub.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tblDoa")
data class Doa(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val judul: String,
    val isi: String,
    val tanggal: String,

)



