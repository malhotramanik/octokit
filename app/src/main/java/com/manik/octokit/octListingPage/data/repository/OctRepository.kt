package com.manik.octokit.octListingPage.data.repository

import com.manik.octokit.base.repository.BaseRepository
import com.manik.octokit.octListingPage.data.db.AppDataBase
import com.manik.octokit.octListingPage.data.network.OctApi

class OctRepository(
    private val octApi: OctApi,
    private val db: AppDataBase
) : BaseRepository() {

    suspend fun getOctokit(page: Int, perPage: Int) =
        safeApiCall { octApi.getOctokit(page, perPage) }
}