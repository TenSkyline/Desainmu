package com.example.desainmu.presentation.feature.dashboard.components

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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun OrderItemView(item: DashboardItemModel, onClick: () -> Unit) {
    BaseItemView(item = item, onClick = onClick) {
        Text("Tenggat waktu: ${formatDate(item.selectedDate)}", style = MaterialTheme.typography.bodySmall)
        Text("Sisa Hari: ${item.daysLeft}", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun DelayedItemView(item: DashboardItemModel, onClick: () -> Unit) {
    BaseItemView(item = item, onClick = onClick) {
        Text("Tanggal Selesai: ${formatDate(item.dateDone)}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.daysOfWork} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun HistoryItemView(item: DashboardItemModel) {
    BaseItemView(item = item, onClick = null) {
        Text("Tanggal Selesai: ${formatDate(item.dateDone)}", style = MaterialTheme.typography.bodySmall)
        Text("Tanggal Pembayaran: ${formatDate(item.datePayed)}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.daysOfWork} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun BaseItemView(
    item: DashboardItemModel,
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
                    checked = item.isDone,
                    onCheckedChange = { onClick() }
                )
            }
        }
    }
}

private fun formatDate(longDate: Long?): String {
    if (longDate == null) return "-"
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return sdf.format(Date(longDate))
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