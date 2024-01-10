package com.example.pam_prayhub.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface PenggunaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPengguna(pengguna: Pengguna)

    @Update
    suspend fun updatePengguna(pengguna: Pengguna)

    @Delete
    suspend fun deletePengguna(pengguna: Pengguna)

    @Query("SELECT * from tblPengguna WHERE id = :id")
    fun getPengguna (id: Int): Flow<Pengguna>

    @Query("SELECT * from tblPengguna ORDER BY nama ASC")
    fun getAllPengguna (): Flow<List<Pengguna>>
}