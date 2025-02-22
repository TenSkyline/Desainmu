package com.example.desainmu.presentation.ui.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desainmu.R
import com.example.desainmu.presentation.theme.DesainmuTheme

@Composable
internal fun ResultRoute(
    navigateUp: () -> Unit = {}
){
//    val viewModel: ResultViewModel = viewModel()
//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    onEvent = viewModel::handleEvent, uiState, navigateUp
    ResultScreen()
}

@Composable
internal fun ResultScreen(
//    onEvent: (ResultEvent) -> Unit,
//    uiState: ResultState,
//    navigateUp: () -> Unit = {}
    ){
    Scaffold(
//        ResultTopBar(navigateUp)
        topBar = {  },
//        ResultContent(padding, design = design, onEvent = onEvent, uiState = uiState)
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.contoh_gambar), // Replace with your image resource
                    contentDescription = "Result Image", // Provide a description
                    modifier = Modifier.size(200.dp)
                )
            }
        }
    )
}

@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
//        AddOrderMeasurementScreen()
    }
}