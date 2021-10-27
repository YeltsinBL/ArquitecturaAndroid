package com.yeltsin.arquitectura_android.view

import com.yeltsin.arquitectura_android.Model.Coupon

interface CouponView {
    fun getCoupons()
    fun showCoupons(coupons: ArrayList<Coupon>)
}