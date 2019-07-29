package com.example.edukacija_masterdetail.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.edukacija_masterdetail.R
import com.example.edukacija_masterdetail.data.repository.Repository
import com.example.edukacija_masterdetail.view_model.AppViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    val myViewModel: AppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        myViewModel.fatchDataFromApi()

        btn_login.setOnClickListener {

            myViewModel.dataFromApi().observe(this, Observer {
                if (it == null) return@Observer
                startActivity(Intent(this, ListActivity::class.java))
            })
        }

    }
}
