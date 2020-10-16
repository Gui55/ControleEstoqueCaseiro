package com.example.controleestoquecaseiro.services.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.controleestoquecaseiro.services.model.Produto
import com.example.controleestoquecaseiro.services.webservices.Requisition
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutoRepository : KoinComponent{

    private val requisition: Requisition by inject()
    var ans = MutableLiveData<Boolean>()

    companion object{
        var instance = ProdutoRepository()
    }

    fun getTheStock() : MutableLiveData<ArrayList<Produto>>{

        var produtos = MutableLiveData<ArrayList<Produto>>()

        requisition.getStock().enqueue(object: Callback<ArrayList<Produto>>{
            override fun onResponse(
                call: Call<ArrayList<Produto>>,
                response: Response<ArrayList<Produto>>
            ) {
                produtos.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<Produto>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return produtos
    }

    fun updateStock(id: Int, produto: Produto){
        requisition.updateStock(id, produto).enqueue(object: Callback<Produto>{
            override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                ans.value = true
            }

            override fun onFailure(call: Call<Produto>, t: Throwable) {
                ans.value = false
            }

        })
    }

}