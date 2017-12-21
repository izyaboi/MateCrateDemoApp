package com.example.lancelotmatecrate.matecratedemoapp

import android.app.Application
import com.example.lancelotmatecrate.matecratedemoapp.di.AppComponent
import com.example.lancelotmatecrate.matecratedemoapp.di.AppModule
import com.example.lancelotmatecrate.matecratedemoapp.di.DaggerAppComponent

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
class MateCrate : Application() {

    lateinit var application: MateCrate

        private set

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        initDagger()
    }


    private fun initDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(application))
                .build()
    }
}