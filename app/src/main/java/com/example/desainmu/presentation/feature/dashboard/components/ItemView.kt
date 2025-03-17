package com.example.desainmu.presentation.feature.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.ItemModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun OrderItemView(item: ItemModel, onClick: (ItemModel) -> Unit, onDelete: (ItemModel) -> Unit) {
    BaseItemView(item = item, onClick = onClick, onDeleteClick = onDelete) {
        Text("Tenggat waktu: ${formatDate(item.selectedDate)}", style = MaterialTheme.typography.bodySmall)
        Text("Sisa Hari: ${item.daysLeft}", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun DelayedItemView(item: ItemModel, onClick: (ItemModel) -> Unit) {
    BaseItemView(item = item, onClick = onClick, onDeleteClick = null) {
        Text("Tanggal Selesai: ${formatDate(item.dateDone)}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.daysOfWork} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun HistoryItemView(item: ItemModel) {
    BaseItemView(item = item, onClick = null, onDeleteClick = null) {
        Text("Tanggal Selesai: ${formatDate(item.dateDone)}", style = MaterialTheme.typography.bodySmall)
        Text("Tanggal Pembayaran: ${formatDate(item.datePayed)}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.daysOfWork} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun BaseItemView(
    item: ItemModel,
    onClick: ((ItemModel) -> Unit)?,
    onDeleteClick: ((ItemModel) -> Unit)?,
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
                    text = item.description,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.size(16.dp))
                additionalContent()
            }
            if (onClick != null) {
                Checkbox(
                    checked = item.isDone || item.isPayed,
                    onCheckedChange = {
                        if (!item.isDone) {
                            // Set isDone = true, isPayed = false
                            onClick(item.copy(isDone = true, isPayed = false))
                        } else {
                            // Set isPayed = true
                            onClick(item.copy(isPayed = true))
                        }
                    }
                )
            }
            if (onDeleteClick != null) {
                IconButton(onClick = { onDeleteClick(item) }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

private fun formatDate(longDate: Long?): String {
    if (longDate == null) return "-"
    val sdf = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
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