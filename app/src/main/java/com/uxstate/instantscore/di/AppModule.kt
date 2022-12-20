package com.uxstate.instantscore.di

import com.uxstate.instantscore.utils.CONNECT_TIMEOUT
import com.uxstate.instantscore.utils.READ_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {


    /*For debugging purposes it’s nice to have a log feature integrated to
show request and response information. */
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {

        return HttpLoggingInterceptor().apply {

            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    /* connect timeout defines a time period in which our
       client should establish a connection with a target host.
  By default, for the OkHttpClient, this timeout is set to 10 seconds.   */

    /*maximum time of inactivity between two data packets when waiting for the
    server's response.The default timeout of 10 seconds */
    @Provides
    @Singleton

    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .build()
    }
}