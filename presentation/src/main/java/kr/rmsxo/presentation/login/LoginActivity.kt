package kr.rmsxo.presentation.login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import kr.rmsxo.presentation.theme.HiltStudy1Theme

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltStudy1Theme {
                LoginNavHost()
            }
        }
    }


}