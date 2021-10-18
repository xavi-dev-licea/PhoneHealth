package com.xavidev.phonehealth.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "reboot")
data class Reboot(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val count: Long,
    val date: Date,
)
