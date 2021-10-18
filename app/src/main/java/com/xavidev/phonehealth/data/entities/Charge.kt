package com.xavidev.phonehealth.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "charge")
data class Charge(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val count: Long,
    val date: Date,
)
