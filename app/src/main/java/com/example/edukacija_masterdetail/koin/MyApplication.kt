package com.example.edukacija_masterdetail.koin

import android.app.Application
import androidx.room.Room
import com.example.edukacija_masterdetail.data.db.Database
import com.example.edukacija_masterdetail.data.network.data_source.DataSource
import com.example.edukacija_masterdetail.data.network.data_source.DataSourceImpl
import com.example.edukacija_masterdetail.data.repository.Repository
import com.example.edukacija_masterdetail.data.repository.RepositoryImpl
import com.example.edukacija_masterdetail.view_model.AppViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {

    single<DataSource> {DataSourceImpl()}

    single{ Room.databaseBuilder(
        get(),
        Database::class.java,
        "local_beer_db"
    ).fallbackToDestructiveMigration().build()}

    single<Repository> {RepositoryImpl(get(), get())}

    viewModel { AppViewModel(get()) }

}

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}