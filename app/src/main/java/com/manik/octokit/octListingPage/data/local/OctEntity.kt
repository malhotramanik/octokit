package com.manik.octokit.octListingPage.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OctEntity(
    @PrimaryKey val uid: Int,
    val openIssuesCount: Int,
    val license: String,
    val permissions: String,
    val name: String,
    val description: String
)