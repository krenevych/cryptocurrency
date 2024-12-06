package com.kre.cryptocurrency.di

import com.kre.cryptocurrency.data.remote.retrofit.BASE_URL_CRYPTO_CURRENCY
import com.kre.cryptocurrency.data.remote.retrofit.ServiceCryptoCurrency
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun providesService() : ServiceCryptoCurrency {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_CRYPTO_CURRENCY)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ServiceCryptoCurrency = retrofit.create(ServiceCryptoCurrency::class.java)
        return service
    }
}