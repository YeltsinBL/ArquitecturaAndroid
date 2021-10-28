package com.yeltsin.arquitectura_android.presenter

import android.content.Context
import com.yeltsin.arquitectura_android.Model.Coupon

interface CouponPresenter {
    /*
        Estos son los casos de uso:
        las acciones que puede hacer el usuario y
        se les reflejará en la pantalla
    */

    /**
     *  Función que irá a la Vista
     *  Mostramos los Coupons
     *
     *  @param coupons Recibe una lista de Coupon
     *
     *  */
    fun showCoupons(coupons: ArrayList<Coupon>?)

    /**
     *  Función que irá al interactor
     * */
    fun getCoupons(context: Context)

}