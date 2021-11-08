package com.yeltsin.arquitectura_android.Model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ApiAdapter {
    val apiKey = "00bcfba611d86fcc9d30a0f7b9fe46ad"
    val urlApi = "http://feed.linkmydeals.com/"

    fun getClientService(): ApiService {
        val authInterceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder()
                .addQueryParameter("API_KEY", apiKey)
                .addQueryParameter("format", "json")
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(url)
                .build()

            chain.proceed(newRequest)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return  retrofit.create(ApiService::class.java)
    }
    /**
     *
     * @param context  es el AssetManager que utilizaremos para abrir el archivo json
     * @return Obtenemos los datos del Archivo json en String
     * */
    fun getJsonDataFromAsset(context: Context): String {
        val fileName = "archivo.json"
        val jsonString: String

        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }


        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return "null"
        }
        return jsonString
    }
}