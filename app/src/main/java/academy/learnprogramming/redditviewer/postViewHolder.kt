package academy.learnprogramming.redditfeed

import academy.learnprogramming.redditviewer.R
import academy.learnprogramming.redditviewer.databinding.ViewPostWholeBinding
import academy.learnprogramming.redditviewer.model.RedditEntry
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PostViewHolder(val wholePostView: ViewPostWholeBinding) :
    RecyclerView.ViewHolder(wholePostView.root) {

    fun bind(redditEntry: RedditEntry) {

        if(redditEntry.post_hint == "image"){
            Picasso.with(wholePostView.thumbnail.context)
                .load(redditEntry.url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(wholePostView.thumbnail)
        }else{
            Log.d("Callum",wholePostView.postTitle.toString())
            wholePostView.thumbnail.visibility = View.GONE
        }

        wholePostView.subredditName.text = redditEntry.subredditName
        wholePostView.postTitle.text = redditEntry.title
    }


}