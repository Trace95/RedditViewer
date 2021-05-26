package academy.learnprogramming.redditfeed

import academy.learnprogramming.redditviewer.R
import academy.learnprogramming.redditviewer.databinding.ViewPostBinding
import academy.learnprogramming.redditviewer.model.RedditEntry
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.math.BigDecimal
import java.math.RoundingMode

class PostViewHolder(val wholePostView: ViewPostBinding) :
    RecyclerView.ViewHolder(wholePostView.root) {

    fun bind(redditEntry: RedditEntry) {

        if (redditEntry.post_hint.equals("image", true)) {
            wholePostView.thumbnail.visibility = View.VISIBLE
            Picasso.with(wholePostView.thumbnail.context)
                .load(redditEntry.url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(wholePostView.thumbnail)
        } else {
            Log.d("Callum", wholePostView.postTitle.toString())
            wholePostView.thumbnail.visibility = View.GONE
        }

        wholePostView.subredditName.text = redditEntry.subredditName
        wholePostView.postTitle.text = redditEntry.title
        wholePostView.author.text = "Posted by u/" + redditEntry.author
        wholePostView.upvotes.text = "Upvotes: " + upvoteScale(redditEntry.upVotes.toString())
        if (redditEntry.post_hint.equals("hosted:video", true)) {
            wholePostView.postTitle.text = wholePostView.postTitle.text as String? + " \n[VIDEO]"
        }
    }

    fun upvoteScale(upvotes: String): String {
        var UpvotesDouble = upvotes.toDouble()
        if (UpvotesDouble > 999) {
            UpvotesDouble /= 1000
            val decimal = BigDecimal(UpvotesDouble).setScale(1, RoundingMode.HALF_EVEN)
            return decimal.toString() + "k"
        }

        return upvotes
    }


}