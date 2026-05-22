package com.jaimes.nodocivico.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReportDao {

    @Insert
    suspend fun insertReport(report: ReportEntity)

    @Query("SELECT * FROM reports")
    suspend fun getAllReports(): List<ReportEntity>
}