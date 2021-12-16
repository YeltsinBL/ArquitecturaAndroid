package com.yeltsin.arquitectura_android.Model

import android.content.Context
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

//Conexión directa con el Repository y ViewModel
class CouponObservable: BaseObservable() {

    //Instancia del Repositorio
    private var couponsRepository: CouponsRepository = CouponsRepositoryImpl()

    //Repository
    fun callCoupon(){
        couponsRepository.callCouponsApi()
    }

    fun callCouponJson(context: Context){
        couponsRepository.callCouponsJson(context)
    }

    //ViewModel
    fun getCoupons(): MutableLiveData<List<Coupon>> {
        Log.w("CouponsObservableGet", "Llegó al Get")
        return couponsRepository.getCoupons()
    }

}