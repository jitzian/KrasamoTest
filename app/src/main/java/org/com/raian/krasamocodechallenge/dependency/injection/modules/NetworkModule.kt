package org.com.raian.krasamocodechallenge.dependency.injection.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.com.raian.krasamocodechallenge.constants.GlobalConstants.Companion.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}