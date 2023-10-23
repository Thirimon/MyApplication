package com.example.myapplication.repository

import com.example.myapplication.data.CheckIn
import com.example.myapplication.data.CheckInDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CheckInRepository @Inject constructor (private val checkInDao: CheckInDao) {
    fun getAllItems(): List<CheckIn>{
        return checkInDao.getAllCheckIns()
    }
    suspend fun insertCheckIn(checkIn: CheckIn){
        withContext(Dispatchers.IO){
            checkInDao.insertCheckIn(checkIn)
        }
    }
}