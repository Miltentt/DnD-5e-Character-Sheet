package com.miltent.networking.di

import com.miltent.core.repository.TheDogRepository
import com.miltent.networking.TheDogApi
import com.miltent.networking.TheDogRepositoryImpl
import com.miltent.networking.util.BASE_URL
import com.miltent.networking.util.HEADER_NAME
import com.miltent.networking.util.THE_DOG_API_KEY
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkingModule {

    @Binds
    fun bindTheDogApi(repository: TheDogRepositoryImpl): TheDogRepository

    companion object{

        @Provides
        @Singleton
        fun provideLogger(): HttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        @Provides
        @Singleton
        fun provideInterceptor(): Interceptor = object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val request =
                    chain.request().newBuilder()
                        .addHeader(HEADER_NAME, THE_DOG_API_KEY)
                        .build()
                return chain.proceed(request)
            }
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(
            logger: HttpLoggingInterceptor,
            interceptor: Interceptor
        ): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(logger)
            .build()

        @Provides
        @Singleton
        fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        @Provides
        @Singleton
        fun provideApi(moshi: Moshi, client: OkHttpClient): TheDogApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(client)
                .build()
                .create<TheDogApi>()
        }
    }
}