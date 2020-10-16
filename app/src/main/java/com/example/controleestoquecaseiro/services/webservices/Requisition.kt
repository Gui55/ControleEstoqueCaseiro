package com.example.controleestoquecaseiro.services.webservices

import com.example.controleestoquecaseiro.services.model.Produto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface Requisition {

    @GET("Homestock")
    fun getStock() : Call<ArrayList<Produto>>

    @PATCH("Homestock/{id}")
    fun updateStock(@Path("id") id: Int, @Body produto: Produto) : Call<Produto>

}