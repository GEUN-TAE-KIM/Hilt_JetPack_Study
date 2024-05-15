package kr.rmsxo.presentation.main.setting

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kr.rmsxo.presentation.component.RMProfileImage
import kr.rmsxo.presentation.login.LoginActivity
import kr.rmsxo.presentation.theme.HiltStudy1Theme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SettingScreen(viewModel: SettingViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val state = viewModel.collectAsState().value

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is SettingSideEffect.Toast -> Toast.makeText(
                context,
                sideEffect.message,
                Toast.LENGTH_LONG
            ).show()

            SettingSideEffect.NavigateToLoginActivity -> {
                context.startActivity(Intent(context, LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }
        }
    }
    SettingScreen(
        username = state.userName,
        profileImageUrl = state.profileImageUrl,
        onImageChangeClick = {},
        onNameChangeClick = {},
        onLogoutClick = viewModel::onLogoutClick,
    )

}

@Composable
fun SettingScreen(
    username: String = "",
    profileImageUrl: String?,
    onImageChangeClick: () -> Unit,
    onNameChangeClick: () -> Unit,
    onLogoutClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box {
            RMProfileImage(
                modifier = Modifier.size(150.dp),
                profileImageUrl = profileImageUrl,
            )

            IconButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = { onImageChangeClick() }
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .border(width = 1.dp, color = Color.Gray, shape = CircleShape)
                        .background(color = Color.White, shape = CircleShape)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(20.dp),
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .clickable { onNameChangeClick() },
            text = username,
            style = MaterialTheme.typography.headlineMedium
        )
        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { onLogoutClick() }
        ) {
            Text("로그아웃")
        }

        val context = LocalContext.current
        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = {
                context.startActivity(
                    Intent(
                        context,
                        Class.forName("")
                    )
                )
            }
        ) {
            Text("Dynamic Feature")
        }
    }
}

@Preview
@Composable
private fun SettingScreenPreview() {
    HiltStudy1Theme {
        Surface {
            SettingScreen(
                username = "",
                profileImageUrl = "",
                onImageChangeClick = {},
                onNameChangeClick = {},
                onLogoutClick = {}
            )
        }
    }
}