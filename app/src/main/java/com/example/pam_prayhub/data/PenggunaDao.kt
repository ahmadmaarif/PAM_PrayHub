package com.example.pam_prayhub.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface SiswaPengguna {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSiswa(siswa: Pengguna)

    @Update
    suspend fun updateSiswa(siswa: Pengguna)

    @Delete
    suspend fun deleteSiswa(siswa: Pengguna)

    @Query("SELECT * from tblPengguna WHERE id = :id")
    fun getSiswa (id: Int): Flow<Pengguna>

    @Query("SELECT * from tblPengguna ORDER BY nama ASC")
    fun getAllSiswa (): Flow<List<Pengguna>>
}