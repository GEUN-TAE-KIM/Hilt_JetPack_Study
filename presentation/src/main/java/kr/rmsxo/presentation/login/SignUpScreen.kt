package kr.rmsxo.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.rmsxo.presentation.component.RMButton
import kr.rmsxo.presentation.component.RMTextField
import kr.rmsxo.presentation.theme.HiltStudy1Theme

@Composable
fun SignUpScreen(
    id: String,
    userName: String,
    password1: String,
    password2: String,
    onIdChange: (String) -> Unit,
    onUserNameChange: (String) -> Unit,
    onPassword1Change: (String) -> Unit,
    onPassword2Change: (String) -> Unit,
    onSignUpClick: () -> Unit
) {
    Surface {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    modifier = Modifier.padding(top = 36.dp),
                    text = "Create an Account",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    modifier = Modifier.padding(top = 36.dp),
                    text = "Id",
                    style = MaterialTheme.typography.labelLarge
                )
                RMTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = id,
                    onValueChange = onIdChange,
                )
                Text(
                    modifier = Modifier.padding(top = 36.dp),
                    text = "UserName",
                    style = MaterialTheme.typography.labelLarge
                )
                RMTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = userName,
                    onValueChange = onUserNameChange,
                )
                Text(
                    modifier = Modifier.padding(top = 36.dp),
                    text = "Password",
                    style = MaterialTheme.typography.labelLarge
                )
                RMTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = password1,
                    onValueChange = onPassword1Change,
                )
                Text(
                    modifier = Modifier.padding(top = 36.dp),
                    text = "Password",
                    style = MaterialTheme.typography.labelLarge
                )
                RMTextField(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    value = password2,
                    onValueChange = onPassword2Change,
                )
                RMButton(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    text = "Sign up",
                    onClick = onSignUpClick
                )
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreView() {
    HiltStudy1Theme {
        SignUpScreen(
            id = "test",
            userName = "Charless",
            password1 = "sd",
            password2 = "sd",
            onIdChange = {},
            onUserNameChange = {},
            onPassword1Change = {},
            onPassword2Change = {},
            onSignUpClick = {}
        )
    }
}