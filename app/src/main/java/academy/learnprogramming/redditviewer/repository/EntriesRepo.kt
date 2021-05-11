package academy.learnprogramming.redditviewer.repository

import academy.learnprogramming.redditviewer.api.NetworkService
import academy.learnprogramming.redditviewer.model.RedditEntry
import academy.learnprogramming.redditviewer.model.RedditResponse
import academy.learnprogramming.redditviewer.util.Constants.Companion.BASE_URL
import android.util.Log


class EntriesRepo {

    suspend fun getRedditResponse(urlExtensions: String): RedditResponse {
        return NetworkService.redditService.getRedditPosts(urlExtensions)
    }

    suspend fun getRedditEntries(): ArrayList<RedditEntry> {
        Log.d("Callum","URL:" + BASE_URL + createUriExtention())
        return unboxRedditResponse(getRedditResponse(createUriExtention()))
    }

    fun createUriExtention(): String {
        // "r/pics/hot.json"
        // default: "/.json"
        // TODO: 11/05/2021 create URI function using subreddit, and relevance type
        return "/.json"
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
                redditResponse.data.children[i].data.url,
                redditResponse.data.children[i].data.post_hint
            )
            redditEntryArray.add(redditEntry)
            i++
            Log.d("Callum",redditEntry.toString())
        }
        return redditEntryArray
    }


}