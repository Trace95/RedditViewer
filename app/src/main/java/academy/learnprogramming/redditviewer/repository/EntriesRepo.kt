package academy.learnprogramming.redditviewer.repository

import academy.learnprogramming.redditviewer.api.NetworkService
import academy.learnprogramming.redditviewer.model.ListingResponseContainer


class EntriesRepo {

    suspend fun getRedditEntries(urlExtensions: String): ListingResponseContainer {
        return NetworkService.redditService.getRedditPosts(urlExtensions)
    }

    fun createUriExtention(): String {
        return "r/pics/hot.json"
    }


}