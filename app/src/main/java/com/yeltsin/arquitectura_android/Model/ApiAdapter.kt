package com.yeltsin.arquitectura_android.Model

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ApiAdapter {
    val apiKey = "USA TU CLAVE"
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