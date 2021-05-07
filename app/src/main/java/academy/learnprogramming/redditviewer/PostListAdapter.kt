package academy.learnprogramming.redditfeed


import academy.learnprogramming.redditviewer.R
import academy.learnprogramming.redditviewer.databinding.ViewPostWholeBinding
import academy.learnprogramming.redditviewer.model.RedditEntry
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PostListAdapter(private var redditEntryList: List<RedditEntry>) :
    RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        Log.d("Callum", "onCreateViewHolder called")
        val view = ViewPostWholeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Log.d("Callum", "onBindViewHolder called")
        if (redditEntryList.isEmpty()) {
            holder.wholePostView.viewPostLayout.thumbnail.setImageResource(R.drawable.placeholder)
            holder.wholePostView.subredditName.setText(R.string.missing_subreddit)
        } else {
            val redditEntry = redditEntryList[position]
            Picasso.with(holder.wholePostView.viewPostLayout.thumbnail.context)
                .load(redditEntry.url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.wholePostView.viewPostLayout.thumbnail)
        }
        holder.bind(
            subredditName = redditEntryList[position].subredditName.toString(),
            postTitle = redditEntryList[position].title.toString()
        )
    }

    override fun getItemCount(): Int {
        return redditEntryList.size
    }

    fun updateRecyclerView(newRedditEntries: List<RedditEntry>) {
        redditEntryList = newRedditEntries
        notifyDataSetChanged()
    }

}