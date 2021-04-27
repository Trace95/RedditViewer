package academy.learnprogramming.redditviewer.api

import academy.learnprogramming.redditviewer.model.RedditResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditService {

    /*
    * @GET appends whatever text is within the brackets to the URL defined within my Retrofit instance
    * That URL with the @GET appended becomes the endpoint for the request. So Now I can call getRedditPosts()
    * and it will send a request to that endpoint and return the json. In this instances what is
    * being appended is being changed to whatever the urlextension value is parsed to this function
    * using @Path.
    */

    @GET("{urlExtension}")
    suspend fun getRedditPosts(@Path("urlExtension") path: String): RedditResponse
}