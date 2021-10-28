package com.yeltsin.arquitectura_android.Model

import android.content.Context
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.yeltsin.arquitectura_android.R
import com.yeltsin.arquitectura_android.presenter.CouponPresenter
import com.yeltsin.arquitectura_android.view.RecyclerCouponsAdapter

//Agregamos el presenter para poder comunicarnos con la interfaz
class CouponsRepositoryImpl(var couponPresenter: CouponPresenter): CouponsRepository {

    /**
     * Logica de la Conexión
     * */
    override fun getCouponsApi( context: Context) {
        //< CONTROLLER>
        var coupons: ArrayList<Coupon>? = ArrayList<Coupon>()
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
//                    coupons?.add(coupon)
//                }
                  //< View>
//                couponPresenter.showCoupons(coupons)
                  //</View>

//            }
//
//
//        })
        //</CONTROLLER>

        /**
         * Utilizamos la funcion de leer Json y lo convertimos en un JsonObject
         * que lo mandaremos a la clase Coupon para que empiece a llenar los datos
         * */
        val jsonFileString = apiAdapter.getJsonDataFromAsset(context)
        var jsonObjectAlt: JsonObject = JsonParser.parseString(jsonFileString).asJsonObject
        val offersJsonArray = jsonObjectAlt.getAsJsonArray("offers")
        offersJsonArray?.forEach { jsonElement: JsonElement ->
            var jsonObject = jsonElement.asJsonObject
            var coupon = Coupon(jsonObject)
            coupons?.add(coupon)
        }
        couponPresenter.showCoupons(coupons)
    }
}