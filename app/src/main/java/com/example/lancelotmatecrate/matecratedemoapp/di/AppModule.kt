package com.example.lancelotmatecrate.matecratedemoapp.di

import com.example.lancelotmatecrate.matecratedemoapp.MateCrate
import com.example.lancelotmatecrate.matecratedemoapp.matecrate.MateCrateController
import com.example.lancelotmatecrate.matecratedemoapp.matecrate.BaseRepository
import com.example.lancelotmatecrate.matecratedemoapp.matecrate.MateCrateRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import com.squareup.picasso.Picasso



/**
 * Created by lancelotmatecrate on 20.12.17.
 */
@Module
class AppModule(val mateCrate: MateCrate) {

    private val baseUrl = "http://api.matecrate.gg/v1/static/test/"
    private val subscribeOn = Schedulers.io()
    private val observeOn = AndroidSchedulers.mainThread()

    private var retrofit: Retrofit? = null

    @Provides
    fun provideRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .callbackExecutor(Executors.newCachedThreadPool())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createHttpClient())
                    .baseUrl(baseUrl)
                    .build()
        }
        return retrofit!!
    }

    private fun createHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val logLevel = HttpLoggingInterceptor.Level.BODY
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = logLevel
        builder.addInterceptor(loggingInterceptor)
        return builder.build()
    }



    @Provides
    fun provideMateCrateController(retrofit: Retrofit): MateCrateController {
        val mateCrateApi = retrofit.create(MateCrateController.MateCrateApi::class.java)
        return MateCrateController(mateCrateApi)
    }


    @Provides
    fun provideMateCrateRepository(mateCrateController: MateCrateController): BaseRepository {
        return MateCrateRepository(mateCrateController, observeOn, subscribeOn)
    }


}