package kr.rmsxo.practice

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    // Inject 주입을 요청
    @Inject
    lateinit var myName: MyName

    override fun onCreate() {
        super.onCreate()

        Log.e("sd", "my name is $myName")
    }
}