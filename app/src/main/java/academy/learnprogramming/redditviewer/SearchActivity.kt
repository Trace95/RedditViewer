package academy.learnprogramming.redditviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import academy.learnprogramming.redditviewer.databinding.ActivitySearchBinding
import android.app.SearchManager
import android.content.Context
import android.view.Menu
import android.widget.SearchView

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search,menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.app_bar_search).actionView as SearchView
        val searchableInfo = searchManager.getSearchableInfo(componentName)
        searchView?.setSearchableInfo(searchableInfo)
        searchView?.queryHint = "Enter Subreddit"
        searchView?.isIconified = false
        return true
    }




}