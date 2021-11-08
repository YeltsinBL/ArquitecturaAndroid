package com.yeltsin.arquitectura_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeltsin.arquitectura_android.R

//Implementamos la funcionalidad del CouponView
class MainActivity : AppCompatActivity() {

    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Ocultar el bar superior
        supportActionBar?.hide()


        //< VIEW>

        //</VIEW>


    }


}