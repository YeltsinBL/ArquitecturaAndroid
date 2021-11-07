package com.yeltsin.arquitectura_android.Model

import android.content.Context


//Agregamos el presenter
class CouponsInteractorImpl(): CouponsInteractor {

    //Conectamos el modulo de la interacción con el modulo del repositorio
    //Instanciamos la clase hija que esta implementada de la interfaz
    private var couponsRepository: CouponsRepository= CouponsRepositoryImpl()
    override fun getCouponsApi(context: Context) {
        couponsRepository.getCouponsApi(context)
    }
}