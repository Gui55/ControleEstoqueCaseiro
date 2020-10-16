package com.example.controleestoquecaseiro.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.controleestoquecaseiro.R
import com.example.controleestoquecaseiro.services.model.Produto
import com.example.controleestoquecaseiro.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.produto_recycler_item.view.*

class ProdutoAdapter(var produtos: ArrayList<Produto>, var viewModel: MainViewModel) : RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name = itemView.product_name
        var amount = itemView.product_amount

        var addStock = itemView.add_button
        var minusStock = itemView.minus_button

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        return ProdutoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.produto_recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {

        val produto = produtos[position]

        holder.name.text = produto.name
        holder.amount.text = produto.quantidade.toString()

        holder.addStock.setOnClickListener {
            produto.quantidade++
            holder.amount.text = produto.quantidade.toString()
            viewModel.updateStock(produto.id, produto) }

        holder.minusStock.setOnClickListener {
            produto.quantidade--
            holder.amount.text = produto.quantidade.toString()
            viewModel.updateStock(produto.id, produto) }

    }

    override fun getItemCount(): Int {
        return produtos.size
    }
}