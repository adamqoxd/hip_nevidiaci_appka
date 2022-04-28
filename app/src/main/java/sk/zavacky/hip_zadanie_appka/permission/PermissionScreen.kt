package sk.zavacky.hip_zadanie_appka.permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import sk.zavacky.hip_zadanie_appka.R
import sk.zavacky.hip_zadanie_appka.destinations.CameraPreviewDestination

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermission(navigator: DestinationsNavigator,modifier: Modifier = Modifier) {
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

    Box(modifier = modifier
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.White,
                    Color.LightGray
                )
            )
        )
        .fillMaxSize(1f)) {
        Column(modifier = modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(modifier = modifier,
                shape = CircleShape,
                colors = ButtonDefaults
                    .buttonColors(backgroundColor = Color(0xFF25D482)),
                border = BorderStroke(3.dp, Color.Black),
                onClick = {
                    cameraPermissionState.launchPermissionRequest()
                    // Navigacie na Bar code scaner ... :D
                    if(cameraPermissionState.hasPermission){
                        navigator.navigate(CameraPreviewDestination)
                    }
                }) {
                Text(text = stringResource(id = R.string.accept_camera_permission),
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center)
            }
        }
    }

}

@Destination()
@Composable
fun CameraPermissionPreview(navigator: DestinationsNavigator) {
    CameraPermission(navigator = navigator)
}