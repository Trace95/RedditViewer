package academy.learnprogramming.redditviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import academy.learnprogramming.redditviewer.databinding.ActivitySearchBinding
import android.view.Menu
import android.widget.SearchView

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search,menu)
        return true
    }




}