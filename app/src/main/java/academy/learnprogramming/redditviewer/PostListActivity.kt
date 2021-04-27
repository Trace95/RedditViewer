package academy.learnprogramming.redditviewer


import academy.learnprogramming.redditfeed.PostListAdapter
import academy.learnprogramming.redditviewer.databinding.ActivityPostlistBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager


class PostListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postListRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.postListRecyclerView.adapter = PostListAdapter()
    }

    override fun onResume() {
        super.onResume()

    }
}