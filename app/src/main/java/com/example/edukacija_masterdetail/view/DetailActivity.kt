package com.example.edukacija_masterdetail.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.edukacija_masterdetail.R
import com.example.edukacija_masterdetail.data.model.Beer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var beerData: Beer? = intent.extras?.getParcelable("data")
        Log.i("data", beerData.toString())

        if (beerData != null) {
            tv_detail_name.text = beerData.name
            tv_detail_price.text = "${beerData.price} €"
            tv_detail_promo.text = "${beerData.promo} %"
            Picasso.get().load(beerData.imageUrl).into(iv_detail_logo)
        }
    }
}
