package academy.learnprogramming.redditviewer

import academy.learnprogramming.redditviewer.model.RedditEntry
import academy.learnprogramming.redditviewer.repository.EntriesRepo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostListActivityViewModel : ViewModel() {

    private val _entriesLiveData = MutableLiveData<ArrayList<RedditEntry>>()
    val entriesLiveData: LiveData<ArrayList<RedditEntry>>
    get() = _entriesLiveData
    private val repo = EntriesRepo()

    init {
       getRedditEntryData()
    }

    fun getRedditEntryData() {
        viewModelScope.launch(Dispatchers.IO) {
            _entriesLiveData.postValue(repo.getRedditEntries())
        }
    }
}