package com.example.controleestoquecaseiro.koin

import com.example.controleestoquecaseiro.services.webservices.Requisition
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val theModules = module {

    single { Retrofit.Builder()
        .baseUrl("https://5e878423781e48001676bce6.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Requisition::class.java)}

}