package com.yeltsin.arquitectura_android.Model

import android.content.Context
import androidx.lifecycle.MutableLiveData

interface CouponsRepository {
    fun getCoupons(): MutableLiveData<List<Coupon>>
    fun callCouponsApi()

}