package com.example.edukacija_masterdetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edukacija_masterdetail.R
import com.example.edukacija_masterdetail.adapter.BeerAdapter
import com.example.edukacija_masterdetail.view_model.AppViewModel
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    val myViewModel : AppViewModel by viewModel()
    var beerAdapter = BeerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recycler_beer_view.layoutManager = LinearLayoutManager(applicationContext)

        search_list.setOnQueryTextListener(this)

        myViewModel.getDataFromDb().observe(this, Observer {
            if(it == null) return@Observer
            beerAdapter.setAdapter(it)
            recycler_beer_view.adapter = beerAdapter
        })
    }

    override fun onQueryTextSubmit(p0: String?): Boolean = false

    override fun onQueryTextChange(p0: String?): Boolean {
        var text : String? = p0
        beerAdapter.filter(text!!)
        return false
    }
}
