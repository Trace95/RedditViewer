package academy.learnprogramming.redditviewer.api

import academy.learnprogramming.redditviewer.util.Constants.Companion.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    //This is an instance of retrofit (a 3rd party networking client)
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                .setLenient()
                .create()))
            .build()
    }

    // this is an instance of your RedditService (created by retrofit) which is an object
    // which will allow you to make request and receive responses pertaining to reddit.
    // Its functions are determined by the RedditService interface that you defined.
    val redditService: RedditService by lazy {
        retrofit.create(RedditService::class.java)
    }
}