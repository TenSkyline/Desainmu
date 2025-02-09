package com.example.desainmu

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.desainmu.presentation.addOrder.AddOrderScreen
import com.example.desainmu.presentation.dashboard.DashboardRoute
import com.example.desainmu.presentation.dashboard.navigation.DASHBOARD_ROUTE
import com.example.desainmu.presentation.navigation.DesainmuNavigation
import com.example.desainmu.ui.theme.DesainmuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesainmuTheme {
                DesainmuNavigation()
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {

}
