package com.example.desainmu.presentation.ui.result.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.desainmu.R
import com.example.desainmu.model.Design

@Composable
fun ResultDesignImage(selectedDesign: Design) {
    when (selectedDesign) {
        Design.KaosLakiPolaDasar -> KaosLakiPolaDasarImage()
        Design.Celana -> CelanaImage()
        Design.KemejaL -> KemejaLImage()
        Design.KemejaP -> KemejaPImage()
        Design.Rok -> RokImage()
        Design.AtasanPerempuan -> AtasanPerempuanImage()
    }
}

@Composable
fun KaosLakiPolaDasarImage() {
    ResultZoomableImage(
        painter = painterResource(id = R.drawable.design_kaos),
        contentDescription = "Result Image",
        modifier = Modifier
            .height(350.dp)
            .width(300.dp)
            .border(2.dp, Color.Black)
    )
}

@Composable
fun CelanaImage() {
    Text("Todo")
}

@Composable
fun KemejaLImage() {
    Text("Todo")
}

@Composable
fun KemejaPImage() {
    Text("Todo")
}

@Composable
fun RokImage() {
    Text("Todo")
}

@Composable
fun AtasanPerempuanImage() {
    Text("Todo")
}
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        when (selectedDesign) {
//            Design.KaosLakiPolaDasar -> {
//                ResultZoomableImage(
//                    painter = painterResource(id = R.drawable.design_kaos),
//                    contentDescription = "Result Image",
//                    modifier = Modifier
//                        .height(350.dp)
//                        .width(300.dp)// Set the size of the box
//                        .border(
//                            2.dp,
//                            Color.Black
//                        ) // Optional: Add a border to visualize the box
//                )
//            }
//
//            Design.Celana -> {
//                Text("Todo")
//            }
//
//            Design.KemejaL -> {
//                Text("Todo")
//            }
//
//            Design.KemejaP -> {
//                Text("Todo")
//            }
//
//            Design.Rok -> {
//                Text("Todo")
//            }
//
//            Design.AtasanPerempuan -> {
//                Text("Todo")
//            }
//        }
//    }
