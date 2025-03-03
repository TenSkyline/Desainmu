package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
internal fun OrderItemView(item: OrderItemModel, onClick: () -> Unit) {
    BaseItemView(item = item, onClick = onClick) {
        Text("Tenggat waktu: ${item.deadline}", style = MaterialTheme.typography.bodySmall)
        Text("Sisa Hari: ${item.dayLeft}", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun DelayedItemView(item: OrderItemModel, onClick: () -> Unit) {
    BaseItemView(item = item, onClick = onClick) {
        Text("Tanggal Selesai: ${item.deadline}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.dayLeft} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun HistoryItemView(item: OrderItemModel) {
    BaseItemView(item = item, onClick = null) {
        Text("Tanggal Pembayaran: ${item.deadline}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.dayLeft} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun BaseItemView(
    item: OrderItemModel,
    onClick: (() -> Unit)?,
    additionalContent: @Composable () -> Unit
) {
    Surface(
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = item.subtitle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.size(16.dp))
                additionalContent()
            }
            if (onClick != null) {
                Checkbox(
                    checked = item.isChecked,
                    onCheckedChange = { onClick() }
                )
            }
        }
    }
}

//@Preview
//@Composable
//private fun OrderItemPreview() {
//    val item = OrderItemModel(
//        id = 1,
//        title = "tes",
//        subtitle = "TODO()",
//        deadline = "2 august",
//        isChecked = true
//    )
//    DesainmuTheme {
//        OrderItemView(
//            item = item
//        ) { }
//    }
//}