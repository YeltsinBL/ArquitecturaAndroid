package com.yeltsin.arquitectura_android.view

import com.yeltsin.arquitectura_android.Model.Coupon

interface CouponView {
    /**
     *  Función que irá al Presenter
     *  Obtenemos los Coupons
     *  */
    fun getCoupons()

    /**
     *  Función que irá a la Vista
     *  Mostramos los Coupons
     *
     *  @param coupons Recibe una lista de Coupon
     *
     *  */
    fun showCoupons(coupons: ArrayList<Coupon>)
}