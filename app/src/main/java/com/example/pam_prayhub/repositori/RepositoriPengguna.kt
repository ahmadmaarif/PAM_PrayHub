package com.example.pam_prayhub.repositori

import com.example.pam_prayhub.data.Doa
import com.example.pam_prayhub.data.Pengguna
import kotlinx.coroutines.flow.Flow

interface RepositoriPengguna {
    fun getAllPenggunaStream(): Flow<List<Pengguna>>

    fun getPenggunaStream(id : Int): Flow<Pengguna?>

    suspend fun insertPengguna(pengguna: Pengguna)

    suspend fun deletePengguna(pengguna: Pengguna)

    suspend fun updatePengguna(pengguna: Pengguna)
}