package com.example.pearl

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.colorResource
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.pearl.presentation.nav_graph.NavGraph
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.ui.theme.PearlTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        askForSmsPermission()
        setContent {
            PearlTheme{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(id = R.color.primary_background))
                ){
                    NavGraph(startDestination = Route.AuthNavigation.route)
                }
            }
        }
    }

    private fun askForSmsPermission(){
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.SEND_SMS),
                    100
                )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            100 -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


