package academy.learnprogramming.redditviewer.di

import academy.learnprogramming.redditviewer.DataManager
import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PersistanceModule {

    @Singleton
    @Provides
    fun provideDatastore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.createDataStore(name = "query")
    }

    @Singleton
    @Provides
    fun provideDataManager(dataStore: DataStore<Preferences>): DataManager {
        return DataManager(dataStore)
    }
}