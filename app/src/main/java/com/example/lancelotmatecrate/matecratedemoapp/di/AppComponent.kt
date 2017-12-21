package com.example.lancelotmatecrate.matecratedemoapp.di

import com.example.lancelotmatecrate.matecratedemoapp.matecrate.MateCrateFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(mateCrateFragment: MateCrateFragment)

}