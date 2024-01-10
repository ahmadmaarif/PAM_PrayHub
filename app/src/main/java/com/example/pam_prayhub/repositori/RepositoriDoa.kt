package com.example.pam_prayhub.repositori

import com.example.pam_prayhub.data.Doa
import kotlinx.coroutines.flow.Flow

interface RepositoriDoa {
    fun getAllDoaStream(): Flow<List<Doa>>

    fun getDoaStream(id : Int): Flow<Doa?>

    suspend fun insertDoa(doa: Doa)

    suspend fun deleteDoa(doa: Doa)

    suspend fun updateDoa(doa: Doa)
}