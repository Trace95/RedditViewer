package academy.learnprogramming.redditviewer

import academy.learnprogramming.redditfeed.PostListAdapter
import academy.learnprogramming.redditviewer.databinding.ActivityPostlistBinding
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager


class PostListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostlistBinding
    private val viewModel: PostListActivityViewModel by viewModels()
    private val redditRecyclerViewAdapter = PostListAdapter(ArrayList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostlistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.postListRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.postListRecyclerView.adapter = redditRecyclerViewAdapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.entriesLiveData.observe(this, androidx.lifecycle.Observer {
            redditRecyclerViewAdapter.updateRecyclerView(it)
        })
    }
}
