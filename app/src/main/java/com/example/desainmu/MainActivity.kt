package com.example.desainmu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.desainmu.data.database.InventoryDatabase
import com.example.desainmu.presentation.navigation.DesainmuNavigation
import com.example.desainmu.presentation.theme.DesainmuTheme

class MainActivity : ComponentActivity() {

//    private val db by lazy {
//        Room.databaseBuilder(
//            applicationContext,
//            InventoryDatabase::class.java,
//            "desainmu.db"
//        ).build()
//    }
//    private val viewModel by viewModels<ContactViewModel>(
//        factoryProducer = {
//            object : ViewModelProvider.Factory {
//                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                    return ContactViewModel(db.dao) as T
//                }
//            }
//        }
//    )


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
