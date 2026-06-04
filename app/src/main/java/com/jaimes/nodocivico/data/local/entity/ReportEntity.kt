package com.jaimes.nodocivico.data.local
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reports")
data class ReportEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val description: String,

    val category: String,

    val priority: String = "MEDIA",

    val status: String = "OPEN",

    val location: String,

    val pendingSync: Boolean = false
)
