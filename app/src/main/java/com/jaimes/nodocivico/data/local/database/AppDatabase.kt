package com.jaimes.nodocivico.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ReportEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reportDao(): ReportDao
}