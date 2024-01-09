package com.example.pam_prayhub.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface DoaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSiswa(siswa: Doa)

    @Update
    suspend fun updateSiswa(siswa: Doa)

    @Delete
    suspend fun deleteSiswa(siswa: Doa)

    @Query("SELECT * from tbldoa WHERE id = :id")
    fun getSiswa (id: Int): Flow<Doa>

    @Query("SELECT * from tblDoa ORDER BY judul ASC")
    fun getAllSiswa (): Flow<List<Doa>>
}