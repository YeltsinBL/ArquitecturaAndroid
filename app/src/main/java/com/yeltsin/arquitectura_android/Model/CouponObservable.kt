package com.yeltsin.arquitectura_android.Model

import androidx.databinding.BaseObservable

//Conexión directa con el Repository y ViewModel
class CouponObservable: BaseObservable() {

    //Instancia del Repositorio
    private var couponsRepository: CouponsRepository = CouponsRepositoryImpl()

    //Repository
    fun callCoupon(){
    couponsRepository.callCouponsApi()
    }



    //ViewModel

}