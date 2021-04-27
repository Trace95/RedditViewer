package academy.learnprogramming.redditviewer.model
import com.google.gson.annotations.SerializedName

data class ListingResponseContainer(
    val kind: String,
    val data: Data?)

data class Data(
    val children: Array<Something>)

data class Something(
    val kind : String,
    val data: RedditEntry
)

data class RedditEntry(
    @SerializedName("subreddit_name_prefixed")
    val subredditName: String?,
    val thumbnail: String?,
    val title: String?,
    @SerializedName("ups")
    val upVotes: Int?,
    val url: String?
)