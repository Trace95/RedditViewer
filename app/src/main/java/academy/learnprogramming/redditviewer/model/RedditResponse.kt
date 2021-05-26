package academy.learnprogramming.redditviewer.model
import com.google.gson.annotations.SerializedName

data class RedditResponse(
    val kind: String,
    val data: Data?
    )

data class Data(
    @SerializedName("dist")
    val dataArraySize: Int?,
    val children: Array<RedditEntryContainer>)

data class RedditEntryContainer(
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
    val url: String?,
    val post_hint: String?,
    val author: String?,
    val id: String?
)