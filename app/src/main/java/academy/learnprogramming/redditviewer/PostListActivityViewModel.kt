package academy.learnprogramming.redditviewer

import academy.learnprogramming.redditviewer.model.RedditEntry
import academy.learnprogramming.redditviewer.repository.EntriesRepo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListActivityViewModel @Inject constructor(private val repo: EntriesRepo) : ViewModel() {

    private val _entriesLiveData = MutableLiveData<ArrayList<RedditEntry>>()
    val entriesLiveData: LiveData<ArrayList<RedditEntry>>
        get() = _entriesLiveData

    init {
        getRedditEntryData()
    }

    fun getRedditEntryData(query: String? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            _entriesLiveData.postValue(repo.getRedditEntries(query))
        }
    }
}