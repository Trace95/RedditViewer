package academy.learnprogramming.redditviewer

import academy.learnprogramming.redditviewer.repository.EntriesRepo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(IO).launch {
            val repository = EntriesRepo()
            try{
                repository.getRedditEntries(repository.createUriExtention())
               val redditResponse = repository.getRedditEntries(repository.createUriExtention())
                Log.d("callum",redditResponse.data!!.children[0].data.title.toString())


            }catch (e:Exception){
                Log.d("callum",e.toString())
            }

        }

    }
}