package academy.learnprogramming.redditviewer

import academy.learnprogramming.redditviewer.model.RedditEntry
import academy.learnprogramming.redditviewer.model.RedditResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostListActivityViewModel: ViewModel() {

    private val redditEntryData = MutableLiveData<ArrayList<RedditEntry>>()

    fun getRedditEntryData(): LiveData<ArrayList<RedditEntry>>{
        return redditEntryData
    }


     fun unboxRedditResponse(redditResponse: RedditResponse) : ArrayList<RedditEntry> {
        val redditEntryArray = ArrayList<RedditEntry>()
        var i = 0
        for ( children in redditResponse.data!!.children){
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