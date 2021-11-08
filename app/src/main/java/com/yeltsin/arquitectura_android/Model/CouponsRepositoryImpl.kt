package com.yeltsin.arquitectura_android.Model

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Agregamos el presenter para poder comunicarnos con la interfaz
class CouponsRepositoryImpl(): CouponsRepository {

    //Creamos una lista con LiveData para que se pueda refrescar
    private var coupons = MutableLiveData<List<Coupon>>()

    //Devolvemos los Coupons
    override fun getCoupons(): MutableLiveData<List<Coupon>> {
        return coupons
    }


    //Aqui se llamará los datos
    /**
     * Logica de la Conexión
     * */
    override fun callCouponsApi( ) {
        //< CONTROLLER>
        var couponsList: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    couponsList?.add(coupon)
                }
                Log.w("CouponsList", couponsList?.get(0)?.title ?: "Vacio")
                //VIEW
                //Agregamos el couponsList al MutableLiveData
                coupons.value = couponsList


            }


        })
        //</CONTROLLER>

        /**
         * Utilizamos la funcion de leer Json y lo convertimos en un JsonObject
         * que lo mandaremos a la clase Coupon para que empiece a llenar los datos
         * */
//        val jsonFileString = apiAdapter.getJsonDataFromAsset(context)
//        var jsonObjectAlt: JsonObject = JsonParser.parseString(jsonFileString).asJsonObject
//        val offersJsonArray = jsonObjectAlt.getAsJsonArray("offers")
//        offersJsonArray?.forEach { jsonElement: JsonElement ->
//            var jsonObject = jsonElement.asJsonObject
//            var coupon = Coupon(jsonObject)
//            coupons?.add(coupon)
//        }

    }

}