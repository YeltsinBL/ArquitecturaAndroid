package com.yeltsin.arquitectura_android.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.yeltsin.arquitectura_android.Model.Coupon
import com.yeltsin.arquitectura_android.Model.ApiAdapter
import com.yeltsin.arquitectura_android.R
import com.yeltsin.arquitectura_android.presenter.CouponPresenter
import com.yeltsin.arquitectura_android.presenter.CouponPresenterImpl
//Implementamos la funcionalidad del CouponView
class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter?= null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Ocultar el bar superior
        supportActionBar?.hide()

        //Instanciamos el objeto
        couponPresenter = CouponPresenterImpl(this)

        //< VIEW>
        rvCoupons = findViewById(R.id.rvCoupons) //UI
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        //</VIEW>

        getCoupons(applicationContext)

    }

    override fun getCoupons(context: Context) {
        couponPresenter?.getCoupons(context)
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {

        rvCoupons?.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
    }
}