package com.example.todokotlin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todokotlin.data.model.Task

@Database(entities = [Task::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}