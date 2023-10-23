package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [CheckIn::class], version = 1, exportSchema = false)
abstract class CheckInDatabase :RoomDatabase(){
    abstract fun checkInDao(): CheckInDao

}