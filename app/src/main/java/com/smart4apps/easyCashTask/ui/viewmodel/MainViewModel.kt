package com.smart4apps.easyCashTask.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smart4apps.easyCashTask.data.model.Competition
import com.smart4apps.easyCashTask.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {


    var competitionsListLiv: MutableStateFlow<List<Competition>> =
        MutableStateFlow(arrayListOf())



    private fun refreshCompetitions() {

        viewModelScope.launch {
            runBlocking {
                try {
                    var res = mainRepository.refreshCompetitions()
                    insertCompetitions(res.competitions?: arrayListOf())
                } catch (exception: Exception) {
                    Log.d("TAG", "refreshCompetitions: error${exception.localizedMessage}")
                }

            }
        }


    }

    fun getAllCompetitions() {
        viewModelScope.launch {
            //refresh data from api
            refreshCompetitions()
            //get data from local storage
            mainRepository.getAllCompetitions().collectLatest {
                competitionsListLiv.emit(it)
            }
        }
    }

    private fun insertCompetitions(competitions: List<Competition>) {
        viewModelScope.launch {
            mainRepository.insertCompetitions(competitions)
        }
    }

}