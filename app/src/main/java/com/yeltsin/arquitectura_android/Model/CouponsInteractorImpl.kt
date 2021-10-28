package com.yeltsin.arquitectura_android.Model

import android.content.Context
import com.yeltsin.arquitectura_android.presenter.CouponPresenter


//Agregamos el presenter
class CouponsInteractorImpl(var couponPresenter: CouponPresenter): CouponsInteractor {

    //Conectamos el modulo de la interacción con el modulo del repositorio
    //Instanciamos la clase hija que esta implementada de la interfaz
    private var couponsRepository: CouponsRepository= CouponsRepositoryImpl(couponPresenter)
    override fun getCouponsApi(context: Context) {
        couponsRepository.getCouponsApi(context)
    }
}