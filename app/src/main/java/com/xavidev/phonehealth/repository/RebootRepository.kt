package com.xavidev.phonehealth.repository

import com.xavidev.phonehealth.data.dao.RebootDao
import com.xavidev.phonehealth.data.entities.Reboot

class RebootRepository(private val rebootDao: RebootDao) {

    suspend fun insert(reboot: Reboot) = rebootDao.insert(reboot)
}