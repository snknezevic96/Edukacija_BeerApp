package com.example.edukacija_masterdetail.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edukacija_masterdetail.R
import com.example.edukacija_masterdetail.data.model.Beer
import com.example.edukacija_masterdetail.view.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item_view.view.*

class BeerAdapter : RecyclerView.Adapter<BeerAdapter.ViewHolder>() {

    var filterList : MutableList<Beer>? = null
    lateinit var dataList : List<Beer>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_view, parent, false))
    }

    override fun getItemCount(): Int = filterList!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = filterList!!.get(position)

        holder.beerName.text = current.name
        holder.beerPrice.text = "\t ${current.price} €"
        holder.beerQuantity.text = current.quantity.toString()
        Picasso.get().load(current.imageUrl).into(holder.beerImage)

        holder.beerBody.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra("data", current)
            it.context.startActivity(intent)
        }
    }

    fun setAdapter(new: List<Beer>) {
        dataList = new.map { it.copy() }
        filterList = new.map { it.copy() } as MutableList<Beer>

    }

    fun filter(filterText : String){
        var text = filterText.toLowerCase()
        filterList?.clear()
        if(text.length == 0) filterList = dataList as MutableList<Beer>
        else{
            for(beer : Beer in dataList){
                if(beer.name?.toLowerCase()!!.contains(text))
                    filterList?.add(beer)
            }
        }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val beerName = itemView.tv_beer_name
        val beerPrice = itemView.tv_beer_price
        val beerQuantity = itemView.tv_beer_quantity
        val beerImage = itemView.iv_beer_logo

        val beerBody = itemView.beer_body
    }
}