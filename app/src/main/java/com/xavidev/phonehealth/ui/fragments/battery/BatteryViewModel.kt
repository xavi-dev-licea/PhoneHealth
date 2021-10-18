package com.xavidev.phonehealth.ui.fragments.battery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xavidev.phonehealth.data.dao.ChargeDao
import com.xavidev.phonehealth.data.database.AppDatabase
import com.xavidev.phonehealth.data.entities.Charge
import com.xavidev.phonehealth.repository.ChargeRepository
import com.xavidev.phonehealth.utils.App
import com.xavidev.phonehealth.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class BatteryViewModel : ViewModel() {

    private var repository: ChargeRepository? = null
    private val chargeDao: ChargeDao = AppDatabase.getInstance(App().getContext()).chargeDao()

    private val _todayCharges: MutableLiveData<Charge> = MutableLiveData()
    val todayCharges: LiveData<Charge> = _todayCharges

    private val _isLoadingTodayCharges: MutableLiveData<Boolean> = MutableLiveData()
    val isLoadingTodayCharges: LiveData<Boolean> = _isLoadingTodayCharges

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> = _errorMessage

    init {
        repository = ChargeRepository(chargeDao)
    }

    fun getChargeByDate(date: Date) = viewModelScope.launch(Dispatchers.IO) {
        repository?.getDataByDate(date)?.collect { charge ->
            when (charge) {
                is Response.Loading -> _isLoadingTodayCharges.value = true
                is Response.Success -> {
                    _isLoadingTodayCharges.value = false
                    _todayCharges.value = charge.value
                }
                is Response.Error -> {
                    _isLoadingTodayCharges.value = false
                    _errorMessage.value = charge.error
                }
            }
        }
    }
}