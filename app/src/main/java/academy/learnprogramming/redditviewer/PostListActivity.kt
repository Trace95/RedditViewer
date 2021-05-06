package academy.learnprogramming.redditviewer

import academy.learnprogramming.redditfeed.PostListAdapter
import academy.learnprogramming.redditviewer.databinding.ActivityPostlistBinding
import academy.learnprogramming.redditviewer.model.RedditEntry
import academy.learnprogramming.redditviewer.repository.EntriesRepo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


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

        var redditEntryArray = ArrayList<RedditEntry>();
        CoroutineScope(IO).launch {
            val repository = EntriesRepo()
            val redditResponse = repository.getRedditEntries(repository.createUriExtention())
            redditEntryArray = viewModel.unboxRedditResponse(redditResponse)
        }

        redditRecyclerViewAdapter.updateRecyclerView(redditEntryArray)
    }
}
