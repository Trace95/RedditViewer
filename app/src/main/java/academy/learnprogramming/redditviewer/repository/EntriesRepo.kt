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

    suspend fun getRedditEntries(query: String?): ArrayList<RedditEntry> {
        Log.d("Callum", "URL:" + BASE_URL + createUriExtention(query))
        return unboxRedditResponse(getRedditResponse(createUriExtention(query)))
    }

    fun createUriExtention(query: String?): String {
        return if (query != null) {
            "r/$query/.json"
        } else
            "/.json"
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
                redditResponse.data.children[i].data.post_hint,
                redditResponse.data.children[i].data.author,
                redditResponse.data.children[i].data.id
            )
            redditEntryArray.add(redditEntry)
            i++
            Log.d("Callum", redditEntry.toString())
        }
        return redditEntryArray
    }


}