package com.xavidev.phonehealth.data.dao

import androidx.room.*
import com.xavidev.phonehealth.data.entities.Charge
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface ChargeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(charge: Charge)

    @Query("SELECT count FROM charge WHERE date= :date")
    suspend fun getDataFromDate(date: Date): Flow<Charge>

    @Query("SELECT count FROM charge WHERE date>= :startDate AND date<= :endDate")
    suspend fun getDataBetweenDates(startDate: Date, endDate: Date): Flow<List<Charge>>

    @Update
    suspend fun update(charge: Charge)

    @Delete
    suspend fun delete(charge: Charge)
}