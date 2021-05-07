package academy.learnprogramming.redditviewer.repository

import academy.learnprogramming.redditviewer.api.NetworkService
import academy.learnprogramming.redditviewer.model.RedditEntry
import academy.learnprogramming.redditviewer.model.RedditResponse


class EntriesRepo {

    suspend fun getRedditResponse(urlExtensions: String): RedditResponse {
        return NetworkService.redditService.getRedditPosts(urlExtensions)
    }

    suspend fun getRedditEntries(): ArrayList<RedditEntry> {
        return unboxRedditResponse(getRedditResponse(createUriExtention()))
    }

    fun createUriExtention(): String {
        return "r/chess/hot.json"
    }

    fun unboxRedditResponse(redditResponse: RedditResponse): ArrayList<RedditEntry> {
        val redditEntryArray = ArrayList<RedditEntry>()
        var i = 0
        for (children in redditResponse.data!!.children) {
            val redditEntry = RedditEntry(
                redditResponse.data.children[i].data.subredditName,
                redditResponse.data.children[i].data.thumbnail,
                redditResponse.data.children[i].data.title,
                redditResponse.data.children[i].data.upVotes,
                redditResponse.data.children[i].data.url
            )
            redditEntryArray.add(redditEntry)
            i++
        }
        return redditEntryArray
    }


}