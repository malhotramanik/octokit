package com.manik.octokit.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manik.octokit.base.repository.BaseRepository
import com.manik.octokit.octListingPage.data.repository.OctRepository
import com.manik.octokit.octListingPage.viewmodel.OctViewModel

class ViewModelFactory(private val repository: BaseRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(OctViewModel::class.java) -> OctViewModel(repository as OctRepository) as T
            else -> throw IllegalArgumentException("Viewmodel class not found")
        }
    }
}