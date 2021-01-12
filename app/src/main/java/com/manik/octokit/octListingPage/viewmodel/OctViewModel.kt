package com.manik.octokit.octListingPage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.manik.octokit.octListingPage.data.repository.OctRepository

class OctViewModel(private val octRepository: OctRepository) : ViewModel() {

    fun getOctokitList(page: Int, perPage: Int = 10) =
        liveData { emit(octRepository.getOctokit(page, perPage)) }
}