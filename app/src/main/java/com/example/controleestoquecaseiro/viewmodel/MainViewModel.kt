package com.example.controleestoquecaseiro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.controleestoquecaseiro.services.model.Produto
import com.example.controleestoquecaseiro.services.repository.ProdutoRepository

class MainViewModel : ViewModel() {

    private var mutableAnswer = ProdutoRepository.instance.ans
    var answer : LiveData<Boolean> = mutableAnswer

    private var mutableProdutos = ProdutoRepository.instance.getTheStock()
    var produtos : LiveData<ArrayList<Produto>> = mutableProdutos

    fun updateStock(id: Int, produto: Produto){
        ProdutoRepository.instance.updateStock(id, produto)
    }
}