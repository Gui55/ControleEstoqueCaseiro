package com.example.controleestoquecaseiro.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controleestoquecaseiro.R
import com.example.controleestoquecaseiro.koin.theModules
import com.example.controleestoquecaseiro.ui.adapter.ProdutoAdapter
import com.example.controleestoquecaseiro.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.startKoin

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin(this, listOf(theModules))

        recycle.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        observations()
    }

    //O OptionsMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_act_menu, menu)

        //Inicialização da SearchView
        var searchView = menu?.findItem(R.id.search_view)?.actionView as SearchView

        //Configurações da SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    private fun observations() {
        viewModel.produtos.observe(this, Observer{
            recycle.adapter = ProdutoAdapter(it, viewModel)
        })

        viewModel.answer.observe(this, Observer{
            when(it){

                false -> {
                    Toast.makeText(this, "Erro: Não foi possível atualizar o estoque", Toast.LENGTH_SHORT).show()
                }

            }
        })
    }
}