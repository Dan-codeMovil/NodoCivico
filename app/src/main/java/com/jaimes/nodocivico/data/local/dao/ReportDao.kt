package com.jaimes.nodocivico.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ReportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReport(report: ReportEntity)

    @Update
    suspend fun updateReport(report: ReportEntity)

    @Query("SELECT * FROM reports")
    suspend fun getAllReports(): List<ReportEntity>

    @Query("SELECT * FROM reports WHERE id = :id")
    suspend fun getReportById(id: Int): ReportEntity?
}