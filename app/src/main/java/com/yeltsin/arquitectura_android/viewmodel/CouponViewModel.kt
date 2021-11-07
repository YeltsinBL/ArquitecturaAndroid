package com.yeltsin.arquitectura_android.viewmodel

import androidx.lifecycle.ViewModel
import com.yeltsin.arquitectura_android.Model.CouponObservable

//Maneja los estados de las vistas y
//Las conexiones del Observable
class CouponViewModel:ViewModel() {

    //Instancia del Observable
    private var couponObservable: CouponObservable = CouponObservable()

    /**
     * Primera llamada de los Coupons
     * */
    fun callCoupons(){
        couponObservable.callCoupon()
    }


}