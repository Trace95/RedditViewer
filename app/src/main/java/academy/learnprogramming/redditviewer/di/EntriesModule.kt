package academy.learnprogramming.redditviewer.di

import academy.learnprogramming.redditviewer.repository.EntriesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object EntriesModule {
    @Provides
    fun provideEntiresRepo(): EntriesRepo {
        return EntriesRepo()
    }

}