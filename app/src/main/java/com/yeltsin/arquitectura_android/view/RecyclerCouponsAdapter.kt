package com.yeltsin.arquitectura_android.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yeltsin.arquitectura_android.BR
import com.yeltsin.arquitectura_android.Model.Coupon
import com.yeltsin.arquitectura_android.viewmodel.CouponViewModel

class RecyclerCouponsAdapter( var couponViewModel: CouponViewModel, var resource: Int) : RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    private var coupons: List<Coupon>? = null
    private  var coupon:Coupon?=null
    //Agregamos el metodo para recibir la lista de Coupons
    fun setCouponsList(coupons: List<Coupon>?){
        Log.w("CouponsViewHolder", coupons?.get(0)?.title ?: "setCouponsList")

        this.coupons = coupons
    }

    fun setCoupon(coupon: Coupon?){
        if (coupon != null) {
            Log.w("CouponViewHolder", coupon.title ?: "setCouponsList")
        }
        this.coupon=coupon
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        Log.w("CouponsViewHolder", "Llega")
        //Inicializamos el layout inflater
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        //Rellenamos el binding p1= ViewType, p0=ViewGroup y false para que no lo adjunte al padre
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        //Habilitamos todos los componentes view del CardCouponHolder para que funcionen con el Binding
        return  CardCouponHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.w("CouponsViewHolderSize", coupons?.size.toString() )
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        p0.setDataCard(couponViewModel, p1)
        p0.itemView.setOnClickListener {
            coupon?.let { Log.w("CouponViewHolder", it.title ) }
            val context=p0.itemView.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupons?.get(p1))
            context.startActivity(showPhotoIntent)
        }
    }

    //Se utilizará cuando se pasa los recursos de manera independiente
    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }

    class CardCouponHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(couponViewModel: CouponViewModel, position: Int){
            Log.w("CouponsDataCard", "Llega")
            //Se conecta con el activity_main
            binding?.setVariable(BR.model, couponViewModel)
            Log.w("CouponsDataCard", couponViewModel.getCoupons().value?.get(0)?.category ?: "No llega")
            //Se conecta con el card_coupon
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()

        }


    }

}
