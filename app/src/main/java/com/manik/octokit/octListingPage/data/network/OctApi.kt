package com.manik.octokit.octListingPage.data.network

import com.manik.octokit.octListingPage.response.OctResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OctApi {

    @GET("orgs/octokit/repos")
    suspend fun getOctokit(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<OctResponse>
}