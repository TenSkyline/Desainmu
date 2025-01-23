package com.example.desainmu.presentation.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun OrderItemView (item: OrderItemModel, onClick: () -> Unit) {
    Surface {
        Row (
            Modifier.padding(8.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column (
                Modifier.weight(1f)
            ){
                Text("Title")
                Spacer(Modifier.size(16.dp))
                Text("Subtitle")
                Spacer(Modifier.size(24.dp))
                Text("Deadline")
            }
            Checkbox(
                checked = item.isChecked,
                onCheckedChange = { onClick.invoke() }
            )
        }
        
    }
}

@Preview
@Composable
private fun OrderItemPreview () {
    val item = OrderItemModel(
        title = "tes",
        subtitle = "TODO()",
        deadline = "2 august",
        isChecked = true
    )
    DesainmuTheme { OrderItemView(
        item = item
    ) { } }
}