package academy.learnprogramming.redditviewer


import academy.learnprogramming.redditfeed.PostListAdapter
import academy.learnprogramming.redditviewer.databinding.ActivityPostlistBinding
import academy.learnprogramming.redditviewer.model.RedditEntry
import academy.learnprogramming.redditviewer.repository.EntriesRepo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class PostListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostlistBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postListRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.postListRecyclerView.adapter = PostListAdapter(ArrayList())
    }

    override fun onResume() {
        super.onResume()
        CoroutineScope(IO).launch {
            val repository = EntriesRepo()
            val redditResponse = repository.getRedditEntries(repository.createUriExtention())
            val redditEntryArray = ArrayList<RedditEntry>()

            var i = 0
            for ( children in redditResponse.data!!.children){

                val redditEntry = RedditEntry(
                    redditResponse.data!!.children[i].data.subredditName,
                    redditResponse.data.children[i].data.thumbnail,
                    redditResponse.data.children[i].data.title,
                    redditResponse.data.children[i].data.upVotes,
                    redditResponse.data.children[i].data.url
                )
                redditEntryArray.add(redditEntry)
                i++
            }

        }


    }
}
