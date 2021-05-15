package academy.learnprogramming.redditfeed


import academy.learnprogramming.redditviewer.databinding.ViewPostWholeBinding
import academy.learnprogramming.redditviewer.model.RedditEntry
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class PostListAdapter(private var redditEntryList: List<RedditEntry>) :
    RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        Log.d("Callum", "onCreateViewHolder called")
        val view = ViewPostWholeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Log.d("Callum", "onBindViewHolder called")
        holder.bind(
            redditEntryList[position]
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