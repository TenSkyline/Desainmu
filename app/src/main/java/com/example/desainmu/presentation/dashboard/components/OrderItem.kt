package com.example.desainmu.presentation.dashboard.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun OrderItemView(item: OrderItemModel, onClick: () -> Unit) {
    Surface(
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    item.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    item.subtitle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.size(16.dp))
                Text("Tenggat waktu: " + item.deadline, style = MaterialTheme.typography.bodySmall)
                Text("Sisa Hari: " + item.dayLeft, style = MaterialTheme.typography.bodySmall)
            }
            Checkbox(
                checked = item.isChecked,
                onCheckedChange = { onClick.invoke() }
            )
        }

    }
}

@Composable
internal fun DelayedItemView(item: OrderItemModel, onClick: () -> Unit) {
    Surface(
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    item.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    item.subtitle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.size(16.dp))
                Text("Tanggal Selesai: " + item.deadline, style = MaterialTheme.typography.bodySmall)
                Text("Lama Pengerjaan: " + item.dayLeft + " Hari", style = MaterialTheme.typography.bodySmall)
            }
            Checkbox(
                checked = item.isChecked,
                onCheckedChange = { onClick.invoke() }
            )
        }

    }
}

@Composable
internal fun HistoryItemView(item: OrderItemModel, onClick: () -> Unit) {
    Surface(
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    item.title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    item.subtitle,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.size(16.dp))
                Text("Tanggal Pembayaran: " + item.deadline, style = MaterialTheme.typography.bodySmall)
                Text("Lama Pengerjaan: " + item.dayLeft + " Hari", style = MaterialTheme.typography.bodySmall)
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