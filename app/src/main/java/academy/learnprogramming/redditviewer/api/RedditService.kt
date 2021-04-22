package academy.learnprogramming.redditviewer.api

import academy.learnprogramming.redditviewer.model.RedditResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RedditService {

    @GET("{urlExtension}")
    suspend fun getRedditPosts(@Path("urlExtension") path: String): RedditResponse
}