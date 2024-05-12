package com.example.mytaskapplication

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor


@Entity(tableName= "To_Do")
data class Entity (
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var title: String,
    var priority: String,
    var description: String,
    var date: String
)
