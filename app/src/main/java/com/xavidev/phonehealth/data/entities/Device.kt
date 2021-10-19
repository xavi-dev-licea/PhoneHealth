package com.xavidev.phonehealth.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device")
data class Device(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val year: Int,
    val brand: String,
    val model: String
)
