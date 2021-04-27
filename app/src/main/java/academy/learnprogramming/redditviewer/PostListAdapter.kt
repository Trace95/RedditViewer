package academy.learnprogramming.redditfeed


import academy.learnprogramming.redditviewer.databinding.ViewPostWholeBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostListAdapter : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = ViewPostWholeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind("subredditName", "postTitle")
    }

    override fun getItemCount(): Int {
        return 5
    }

}