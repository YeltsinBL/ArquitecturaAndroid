package com.yeltsin.arquitectura_android.Model

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

    //ViewModel
    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponsRepository.getCoupons()
    }

}