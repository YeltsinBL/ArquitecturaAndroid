package com.yeltsin.arquitectura_android.view

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Ocultar el bar superior
        supportActionBar?.hide()

        //Instanciamos el objeto
        //couponPresenter = CouponPresenterImpl()

        //< VIEW>
        val rvCoupons: RecyclerView = findViewById(R.id.rvCoupons) //UI
        rvCoupons.layoutManager = LinearLayoutManager(this)
        val coupons = ArrayList<Coupon>()
        //</VIEW>

        //< CONTROLLER>
        val apiAdapter = ApiAdapter()
//        val apiService = apiAdapter.getClientService()
//        val call = apiService.getCoupons()
//
//        call.enqueue(object : Callback<JsonObject> {
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                t.message?.let { Log.e("ERROR: ", it) }
//                t.stackTrace
//            }
//
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                val offersJsonArray = response.body()?.getAsJsonArray("offers")
//                offersJsonArray?.forEach { jsonElement: JsonElement ->
//                    var jsonObject = jsonElement.asJsonObject
//                    var coupon = Coupon(jsonObject)
//                    coupons.add(coupon)
//                }
//                //< VIEW>
//                rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
//                //</VIEW>
//            }
//
//
//        })
        //</CONTROLLER>

        /**
         * Utilizamos la funcion de leer Json y lo convertimos en un JsonObject
         * que lo mandaremos a la clase Coupon para que empiece a llenar los datos
         * */
        val jsonFileString = apiAdapter.getJsonDataFromAsset(applicationContext)
        var jsonObjectAlt: JsonObject = JsonParser.parseString(jsonFileString).asJsonObject
        val offersJsonArray = jsonObjectAlt.getAsJsonArray("offers")
        offersJsonArray?.forEach { jsonElement: JsonElement ->
            var jsonObject = jsonElement.asJsonObject
            var coupon = Coupon(jsonObject)
            coupons.add(coupon)
        }
        //< VIEW>
        rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        //</VIEW>


    }

    override fun getCoupons() {
        TODO("Not yet implemented")
    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        TODO("Not yet implemented")
    }
}