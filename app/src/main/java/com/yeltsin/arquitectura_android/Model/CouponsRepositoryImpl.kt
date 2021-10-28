package com.yeltsin.arquitectura_android.Model

import com.yeltsin.arquitectura_android.presenter.CouponPresenter

//Agregamos el presenter para poder comunicarnos con la interfaz
class CouponsRepositoryImpl(var couponPresenter: CouponPresenter): CouponsRepository {

    /**
     * Logica de la Conexión
     * */
    override fun getCouponsApi() {
        TODO("Not yet implemented")

        //couponPresenter.showCoupons()
    }
}