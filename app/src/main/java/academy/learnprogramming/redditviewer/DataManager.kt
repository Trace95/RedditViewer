package academy.learnprogramming.redditviewer

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class DataManager @Inject constructor(val dataStore: DataStore<Preferences>) {

    companion object {
        val QUERY_KEY = preferencesKey<String>("QUERY")
    }

    suspend fun storeQuery(query: String) {
        dataStore.edit {
            it[QUERY_KEY] = query
        }
    }

    val queryFlow: kotlinx.coroutines.flow.Flow<String> = dataStore.data.map {
        it[QUERY_KEY] ?: ""
    }

}