package kr.rmsxo.practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.Lazy
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import kr.rmsxo.practice.ui.theme.HiltStudy1Theme
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var lazyFoo: Provider<Foo>

    @Inject
    lateinit var car : Car

    @Inject
    lateinit var str : Set<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assert(this::lazyFoo.isInitialized)

        Log.d("sd", "엔진 타입 = ${car.engine}")

        Log.d("sd", "set = ${str.toString()}")

        setContent {
            HiltStudy1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("rms")
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltStudy1Theme {
        Greeting("Android")
    }
}