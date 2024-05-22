package kr.rmsxo.presentation.main.writing

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.rmsxo.presentation.theme.HiltStudy1Theme

@AndroidEntryPoint
class WritingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltStudy1Theme {
                WritingNavHost{ finish() }
            }
        }
    }
}