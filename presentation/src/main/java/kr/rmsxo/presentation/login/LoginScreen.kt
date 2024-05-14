package kr.rmsxo.presentation.login

import android.content.Intent
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.rmsxo.presentation.MainActivity
import kr.rmsxo.presentation.component.RMButton
import kr.rmsxo.presentation.component.RMTextField
import kr.rmsxo.presentation.theme.HiltStudy1Theme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToSignUpScreen: () -> Unit,
) {
    val state = viewModel.collectAsState().value
    val context = LocalContext.current

    // 서버에서 실제 로그인 시도 할 시
    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is LoginSideEffect.Toast -> Toast.makeText(
                context,
                sideEffect.message,
                Toast.LENGTH_LONG
            ).show()
            LoginSideEffect.NavigateToMainActivity -> {
                context.startActivity(
                    Intent(
                        context, MainActivity::class.java
                    ).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                )
            }
        }
    }

    LoginScreen(
        id = state.id,
        password = state.password,
        onIdChange = viewModel::onIdChange,
        onPasswordChange = viewModel::onPasswordChange,
        onNavigateToSignUpScreen = onNavigateToSignUpScreen,
        onLoginClick = viewModel::onLoginClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginScreen(
    id: String,
    password: String,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToSignUpScreen: () -> Unit,
    onLoginClick: () -> Unit,
) {

    val context = LocalContext.current

    Surface {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(top = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Connected",
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = "Your favorite Social network",
                    style = MaterialTheme.typography.labelSmall
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 36.dp),
                    text = "Log in",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Id",
                    style = MaterialTheme.typography.labelLarge
                )
                RMTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = id,
                    onValueChange = onIdChange
                )

                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "passWord",
                    style = MaterialTheme.typography.labelLarge
                )
                RMTextField(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    value = password,
                    visualTransformation = PasswordVisualTransformation(),
                    onValueChange = onPasswordChange
                )
                RMButton(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth(),
                    text = "로그인",
                    // onClick = onLoginClick
                    onClick = {

                        // 바로 그냥 화면 천이
                        context.startActivity(
                            Intent(
                                context, MainActivity::class.java
                            ).apply {
                                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            }
                        )
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 24.dp)
                        .clickable(onClick = onNavigateToSignUpScreen)
                ) {
                    Text(text = "Don't have an account?")
                    Text(
                        text = "Sign up",
                        color = MaterialTheme.colorScheme.primary
                    )

                }
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginScreenPreView() {
    HiltStudy1Theme {
        LoginScreen(
            id = "sd",
            password = "sd",
            onIdChange = {},
            onPasswordChange = {},
            onNavigateToSignUpScreen = {},
            onLoginClick = {},
        )
    }
}

