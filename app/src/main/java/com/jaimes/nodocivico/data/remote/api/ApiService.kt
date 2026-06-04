package com.jaimes.nodocivico.data.remote.api
import com.jaimes.nodocivico.data.local.ReportEntity
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("reports")
    suspend fun getReports(): Response<List<ReportEntity>>

    @POST("reports")
    suspend fun createReport(
        @Body report: ReportEntity
    ): Response<ReportEntity>

    @PUT("reports/{id}")
    suspend fun updateReport(
        @Path("id") id: Int,
        @Body report: ReportEntity
    ): Response<ReportEntity>

}
