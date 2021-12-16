package com.yeltsin.arquitectura_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yeltsin.arquitectura_android.Model.Coupon
import com.yeltsin.arquitectura_android.R
import com.yeltsin.arquitectura_android.databinding.ActivityMainBinding
import com.yeltsin.arquitectura_android.viewmodel.CouponViewModel

//Implementamos la funcionalidad del CouponView
class MainActivity : AppCompatActivity() {

    //Llamada al ViewModel
    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //Ocultar el bar superior
        supportActionBar?.hide()

        //< VIEW>
        setUpBinding(savedInstanceState)
        //</VIEW>
    }

    //Pone en acción el Binding que se a hecho en el activity
    fun setUpBinding(savedInstanceState: Bundle?){
        var activityMainBinding:ActivityMainBinding
        = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

//        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
//        activityMainBinding.setModel(couponViewModel)

        couponViewModel = ViewModelProvider.NewInstanceFactory().create(CouponViewModel::class.java)
        //activityMainBinding.model
        activityMainBinding.model = couponViewModel

        setUpListUpdate()
    }

    //Llamamos al ViewModel
    fun setUpListUpdate(){
        //Llamada de Coupons
        couponViewModel?.callCoupons()
        //couponViewModel?.callCouponsJson(this@MainActivity)
        //Devuelve lista de Coupons
        couponViewModel?.getCoupons()?.observe(this@MainActivity, Observer { coupons: List<Coupon> ->
            Log.w("CouponsMAPrev", coupons[0].title)
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
            Log.w("CouponsMA", coupons[0].title)
        })
    }


}