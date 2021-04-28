package academy.learnprogramming.redditfeed

import academy.learnprogramming.redditviewer.databinding.ViewPostWholeBinding
import androidx.recyclerview.widget.RecyclerView

class PostViewHolder(val wholePostView: ViewPostWholeBinding) :
    RecyclerView.ViewHolder(wholePostView.root) {

    fun bind(subredditName: String, postTitle: String) {
        wholePostView.subredditName.text = subredditName
        wholePostView.viewPostLayout.postTitle.text = postTitle
    }



}