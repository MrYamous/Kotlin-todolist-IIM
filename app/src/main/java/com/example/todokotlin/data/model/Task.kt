package com.example.todokotlin.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var label: String,
    var isDone: Boolean
)