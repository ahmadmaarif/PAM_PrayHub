package com.example.pam_prayhub.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblPengguna")
data class Pengguna(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val email: String,
)
