package com.manik.octokit.octListingPage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.manik.octokit.base.ViewModelFactory
import com.manik.octokit.base.network.RemoteDataSource
import com.manik.octokit.base.network.Resource
import com.manik.octokit.databinding.ActivityMainBinding
import com.manik.octokit.octListingPage.data.db.AppDataBase
import com.manik.octokit.octListingPage.data.network.OctApi
import com.manik.octokit.octListingPage.data.repository.OctRepository
import com.manik.octokit.octListingPage.response.OctResponse
import com.manik.octokit.octListingPage.viewmodel.OctViewModel

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: OctViewModel
    private lateinit var octListAdapter: OctListAdapter
    private val octList = ArrayList<OctResponse>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        /*Setup ViewModel*/
        val api = RemoteDataSource().buildApi(OctApi::class.java)
        val db = AppDataBase(this)
        val repository = OctRepository(api, db)
        val factory = ViewModelFactory(repository)
        
        viewModel = ViewModelProvider(this, factory).get(OctViewModel::class.java)
        
        /*UI*/
        binding.recyclervirew.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        
        binding.recyclervirew.setItemAnimator(DefaultItemAnimator())
        
        octListAdapter = OctListAdapter(octList)
        binding.recyclervirew.adapter = octListAdapter
        
        
        /*Observer*/
        viewModel.getOctokitList(1).observe(this, {
            when (it) {
                is Resource.Success -> {
                    Log.e("result", it.value.toString())
                    setList(it.value)
                }
                is Resource.Failure -> Log.e("result", "${it.errorCode} > ${it.errorBody}")
            }
        })
        
        
    }
    
    private fun setList(list: List<OctResponse>) {
        if (list.size > 0) {
            octList.addAll(list)
            octListAdapter.notifyDataSetChanged()
        }
        
    }
}