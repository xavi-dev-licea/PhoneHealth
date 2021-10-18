package com.xavidev.phonehealth.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.xavidev.phonehealth.data.entities.Reboot

@Dao
interface RebootDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reboot: Reboot)
}