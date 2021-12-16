package com.yeltsin.arquitectura_android.viewmodel

import android.content.Context
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import com.yeltsin.arquitectura_android.Model.Coupon
import com.yeltsin.arquitectura_android.Model.CouponObservable
import com.yeltsin.arquitectura_android.R
import com.yeltsin.arquitectura_android.view.RecyclerCouponsAdapter
import de.hdodenhof.circleimageview.CircleImageView

//Maneja los estados de las vistas y
//Las conexiones del Observable
class CouponViewModel:ViewModel() {

    //Instancia del Observable
    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    /**
     * Llamada de los Coupons
     * */
    fun callCoupons(){
        couponObservable.callCoupon()
    }

    fun callCouponsJson(context: Context){
        couponObservable.callCouponJson(context)
    }

    /**
     * Devolvemos los Coupons
     * */
    fun getCoupons(): MutableLiveData<List<Coupon>>{
        return couponObservable.getCoupons()
    }

    /**
     * Recibe los cupones y se le agrega al recyclerview
     * */
    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>){
        recyclerCouponsAdapter?.setCouponsList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
        Log.w("CouponsVM", coupons[0].descriptionShort)
    }

    /**
     * Devuelve los cupones en el Adapter
     **/
    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter?{
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this@CouponViewModel, R.layout.card_coupon)
        Log.w("CouponsAdapterCount", recyclerCouponsAdapter?.couponViewModel?.getCoupons()?.value?.size.toString() )
        Log.w("CouponsAdapter", recyclerCouponsAdapter?.couponViewModel?.getCoupons()?.value?.get(0)?.title ?: "Llegó al adapter")
        return recyclerCouponsAdapter
    }

    /**
    * Capturamos el indice del Coupons seleccionado
    **/
    fun getCouponAt(position: Int): Coupon?{
        Log.w("CouponsCaptura", position.toString())
        var coupons: List<Coupon>? = couponObservable.getCoupons().value
        Log.w("CouponsCaptura", coupons?.get(position)?.title ?: "No llega")
        return coupons?.get(position)
    }
    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?){
            imageUrl?.let {
                if (it.isNotEmpty())
                    Picasso.get().load(it).into(imageView)
            }
        }
    }
}