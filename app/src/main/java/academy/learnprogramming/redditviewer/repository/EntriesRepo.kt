package academy.learnprogramming.redditviewer.repository

import academy.learnprogramming.redditviewer.api.NetworkService
import academy.learnprogramming.redditviewer.model.RedditResponse


class EntriesRepo {

    suspend fun getRedditEntries(urlExtensions: String): RedditResponse {
        return NetworkService.redditService.getRedditPosts(urlExtensions)
    }

    fun createUri(): String {
        return "r/pics/hot.json"
    }


}