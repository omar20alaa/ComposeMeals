package app.compose_meals.di

import app.compose_meals.data.network.ApiClient
import app.compose_meals.utils.NetworkConstants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }


}