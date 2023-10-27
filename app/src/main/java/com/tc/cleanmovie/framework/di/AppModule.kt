package com.tc.cleanmovie.framework.di

import com.google.gson.Gson
import com.tc.cleanmovie.framework.remote.ApiDetails
import com.tc.cleanmovie.framework.remote.ApiEndpoint
import com.tc.cleanmovie.framework.repository.get.RepositoryGet
import com.tc.cleanmovie.framework.repository.get.RepositoryGetImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", ApiDetails.API_BEARER)
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    fun provideRetrofitGet(
        gson: Gson,
        httpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideApiClient(
        retrofit: Retrofit
    ): ApiEndpoint {
        return retrofit.create(ApiEndpoint::class.java)
    }

    @Provides
    fun provideRepositoryGet(
        apiClient: ApiEndpoint
    ): RepositoryGet {
        return RepositoryGetImpl(apiClient)
    }
}