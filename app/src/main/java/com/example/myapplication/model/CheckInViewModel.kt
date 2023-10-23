package com.example.myapplication.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.CheckIn
import com.example.myapplication.repository.CheckInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckInViewModel @Inject constructor(
    private val repo: CheckInRepository) :ViewModel()
{
    private val _checkIns= MutableStateFlow(emptyList<CheckIn>())
    val checkIns: StateFlow<List<CheckIn>> =_checkIns
    init {
        viewModelScope.launch {
           _checkIns.emit(repo.getAllItems())
        }
    }
    fun insertCheckIn(checkIn: CheckIn){
        viewModelScope.launch {
            repo.insertCheckIn(checkIn)
            _checkIns.emit(repo.getAllItems())
        }
    }

}