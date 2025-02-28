package com.example.desainmu.presentation.ui.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.R
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.designMeasurement.components.MeasurementKaosLakiPolaDasarView
import com.example.desainmu.presentation.ui.result.components.ResultTopBar

@Composable
internal fun ResultRoute(
    navigateUp: () -> Unit = {},
//    selectedDesign: Design
){
    val viewModel: ResultViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    onEvent = viewModel::handleEvent, uiState, navigateUp
    ResultScreen(uiState ,navigateUp = navigateUp)
}

@Composable
internal fun ResultScreen(
    uiState: ResultState,
    navigateUp: () -> Unit = {},
//    selectedDesign: Design
    ){
    // Collect the lingkarBadan value from the ViewModel
    Scaffold(
        topBar = { ResultTopBar(navigateUp) },
//        ResultContent(padding, design = design, onEvent = onEvent, uiState = uiState)
        content = { padding ->
//            when (selectedDesign) {
//                Design.KaosLakiPolaDasar -> {
                    KaosLakiPolaDasarResult(padding, uiState = uiState)
                }
//                Design.Celana -> TODO()
//                Design.KemejaL -> TODO()
//                Design.KemejaP -> TODO()
//                Design.Rok -> TODO()
//                Design.AtasanPerempuan -> TODO()
//            }
//        }
    )
}

@Composable
fun KaosLakiPolaDasarResult(padding: PaddingValues, uiState: ResultState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ZoomableImage(
                    painter = painterResource(id = R.drawable.image_kaos),
                    contentDescription = "Result Image",
                    modifier = Modifier
                        .height(350.dp)
                        .width(300.dp)// Set the size of the box
                        .border(2.dp, Color.Black) // Optional: Add a border to visualize the box
                )
            }
        }
        item{
            ResultDetails(uiState = uiState)
        }
        item {
            ElevatedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Simpan")
            }
        }
    }
}

@Composable
fun ZoomableImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var isZoomed by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .clip(RectangleShape)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    isZoomed = true
                    scale = (scale * zoom).coerceIn(1f, 5f)
                    val newOffset = offset + pan
                    val maxX = (size.width * (scale - 1)) / 2
                    val maxY = (size.height * (scale - 1)) / 2
                    offset = Offset(
                        newOffset.x.coerceIn(-maxX, maxX),
                        newOffset.y.coerceIn(-maxY, maxY)
                    )
                }
            }
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offset.x
                    translationY = offset.y
                },
            contentScale = ContentScale.Fit
        )
        if (!isZoomed) {
            Icon(
                imageVector = Icons.Filled.ZoomIn,
                contentDescription = "Zoom In",
                modifier = Modifier
                    .align(Alignment.TopStart) // Align to top-left
                    .padding(8.dp) // Add some padding
                    .size(48.dp), // Increase the size
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun ResultDetails(uiState: ResultState) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Bagian Depan", "Bagian Belakang")

    Column(modifier = Modifier.padding(16.dp)) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (selectedTabIndex) {
            0 -> FrontDetails(uiState)
            1 -> BackDetails(uiState)
        }
    }
}

@Composable
fun FrontDetails(uiState: ResultState) {
    Column {
        Text(
            text = "Bagian Depan",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        ResultRow(label = "AF", value = uiState.lineAF)
        ResultRow(label = "AE", value = uiState.lineAE)
        ResultRow(label = "AK", value = uiState.lineAK)
        ResultRow(label = "AB/DC", value = uiState.lineABDC.toString())
        ResultRow(label = "AI/DJ", value = uiState.lineAIDJ.toString())
        ResultRow(label = "AL/GH", value = uiState.lineALGH)
        ResultRow(label = "AD/IJ/BC", value = uiState.lineADIJBC.toString())
        ResultRow(label = "AG", value = uiState.lineAG.toString())
        ResultRow(label = "Garis lengkung biru HJ", value = uiState.lineHJ.toString())
    }
}

@Composable
fun BackDetails(uiState: ResultState) {
    Column {
        Text(
            text = "Bagian Belakang",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        ResultRow(label = "AF", value = uiState.lineAF)
        ResultRow(label = "AE", value = uiState.lineAE)
        ResultRow(label = "AK", value = uiState.lineAK)
        ResultRow(label = "AB/DC", value = uiState.lineABDC.toString())
        ResultRow(label = "AI/DJ", value = uiState.lineAIDJ.toString())
        ResultRow(label = "AL/GH", value = uiState.lineALGH)
        ResultRow(label = "AD/IJ/BC", value = uiState.lineADIJBC.toString())
        ResultRow(label = "AG", value = uiState.lineAG.toString())
        ResultRow(label = "Garis lengkung biru HJ", value = uiState.lineHJ.toString())
    }
}

@Composable
fun ResultRow(label: String, value: String) {
    Text(text = "$label = $value cm", style = MaterialTheme.typography.bodyMedium)
}


@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
//        AddOrderMeasurementScreen()
    }
}