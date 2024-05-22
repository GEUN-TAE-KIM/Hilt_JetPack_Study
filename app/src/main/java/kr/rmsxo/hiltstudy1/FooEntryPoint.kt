package kr.rmsxo.hiltstudy1

import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.components.SingletonComponent
import kr.rmsxo.data.UserDataStore

/**
 * @author soohwan.ok
 */
@EarlyEntryPoint
@InstallIn(SingletonComponent::class)
interface FooEntryPoint {
    fun foo():Foo

    fun userDataStore(): UserDataStore
}