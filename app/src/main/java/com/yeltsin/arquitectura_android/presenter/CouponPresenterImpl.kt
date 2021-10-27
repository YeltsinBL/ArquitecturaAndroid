package com.yeltsin.arquitectura_android.presenter

import com.yeltsin.arquitectura_android.Model.Coupon
import com.yeltsin.arquitectura_android.view.CouponView

                        //Inyección de Dependencia  -  Implementamos la interfaz
class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        TODO("Not yet implemented")
    }

    override fun getCoupons() {
        TODO("Not yet implemented")
    }
}