package com.example.pam_prayhub.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Doa::class],  version = 1, exportSchema = false)
abstract class DatabasePrayHub : RoomDatabase() {
        abstract fun doaDao(): DoaDao



    companion object {
        @Volatile
        private var Instance: DatabasePrayHub? = null

        fun getDatabase(context: Context): DatabasePrayHub {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DatabasePrayHub::class.java, "DatabasePrayHub")
                    .build().also { Instance = it }
            })
        }
    }
}