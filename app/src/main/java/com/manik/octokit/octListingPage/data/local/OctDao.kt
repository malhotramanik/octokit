package com.manik.octokit.octListingPage.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OctDao {

    @Insert
    suspend fun Insert(octEntity: OctEntity):Long

    @Query("SELECT * FROM octentity")
    suspend fun getOctoKitList():List<OctEntity>
}