package com.jaimes.nodocivico.data.model

data class Report(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val location: String
)