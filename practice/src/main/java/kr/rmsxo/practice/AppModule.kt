package kr.rmsxo.practice

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @IntoSet
    fun provideOneString() : String {
        return "ABC"
    }

    @Provides
    fun provideMultipleString() : Set<String> {
        return listOf<String>("DEF","GHI").toSet()
    }
}