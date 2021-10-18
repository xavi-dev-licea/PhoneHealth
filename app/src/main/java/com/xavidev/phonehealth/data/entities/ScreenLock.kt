package com.xavidev.phonehealth.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "screen_lock")
data class ScreenLock(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val count: Long,
    val date: Date,
)
