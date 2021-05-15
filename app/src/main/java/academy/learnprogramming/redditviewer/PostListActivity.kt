package academy.learnprogramming.redditviewer

import academy.learnprogramming.redditfeed.PostListAdapter
import academy.learnprogramming.redditviewer.databinding.ActivityPostlistBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager


class PostListActivity : BaseActivity() {

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_search -> {
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}
