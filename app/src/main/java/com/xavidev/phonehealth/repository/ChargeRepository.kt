package com.xavidev.phonehealth.repository

import com.xavidev.phonehealth.data.dao.ChargeDao
import com.xavidev.phonehealth.data.entities.Charge
import com.xavidev.phonehealth.utils.Response
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.util.*

class ChargeRepository(private val chargeDao: ChargeDao) {

    suspend fun insert(charge: Charge) = chargeDao.insert(charge)

    suspend fun getDataByDate(date: Date) = flow<Response<Charge>> {
        emit(Response.Loading)
        try {
            val data = chargeDao.getDataFromDate(date)
            data.collect { charge ->
                emit(Response.Success(charge))
            }
        } catch (ex: Exception) {
            emit(Response.Error(ex.message, ex.cause))
        }
    }
}