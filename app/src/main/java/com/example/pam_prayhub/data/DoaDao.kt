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
    suspend fun insertDoa(doa: Doa)

    @Update
    suspend fun updateDoa(doa: Doa)

    @Delete
    suspend fun deleteDoa(doa: Doa)

    @Query("SELECT * from tbldoa WHERE id = :id")
    fun getDoa (id: Int): Flow<Doa>

    @Query("SELECT * from tblDoa ORDER BY judul ASC")
    fun getAllDoa (): Flow<List<Doa>>
}