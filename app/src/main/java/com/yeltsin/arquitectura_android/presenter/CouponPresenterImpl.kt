package com.yeltsin.arquitectura_android.presenter

import android.content.Context
import com.yeltsin.arquitectura_android.Model.Coupon
import com.yeltsin.arquitectura_android.Model.CouponsInteractor
import com.yeltsin.arquitectura_android.Model.CouponsInteractorImpl
import com.yeltsin.arquitectura_android.view.CouponView

                        //Inyección de Dependencia  -  Implementamos la interfaz
class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

   private var couponInteractor: CouponsInteractor = CouponsInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons(context: Context) {
        couponInteractor.getCouponsApi(context)
    }
}