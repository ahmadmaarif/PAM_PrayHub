package com.example.pam_prayhub.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Doa::class], [Pengguna::class], version = 1, exportSchema = false)
abstract class DatabasePrayHub : RoomDatabase() {
        abstract fun DoaDao(): DoaDao
        abstract fun PenggunaDao(): PenggunaDao


    companion object {
        @Volatile
        private var Instance: DatabasePrayHub? = null

        fun getDatabase(context: Context): DatabasePrayHub {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DatabasePrayHub::class.java, "PrayHub_database")
                    .build().also { Instance = it }
            })
        }
    }
}