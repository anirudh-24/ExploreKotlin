package rest

import Constants.Constants
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by anirudh on 27/5/16.
 * Retrofit configuration
 */
class RestApi {

    private val redditApi: RedditApi

    //initialization of class
    init {

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.REDDIT_BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getHttpClient())
                .build()

        redditApi = retrofit.create(RedditApi::class.java)
    }

    //to get OhHttpClient for Retrofit
    private fun getHttpClient(): OkHttpClient {
        val okHttpBuilder = Builder()
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(logger)
        return okHttpBuilder.build()
    }

    //get rest service
    fun getRestService(): RedditApi {
        return redditApi
    }
}
