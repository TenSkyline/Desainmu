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
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun OrderItemView(item: DashboardItemModel, onClick: (DashboardItemModel) -> Unit, onDelete: (DashboardItemModel) -> Unit) {
    BaseItemView(item = item, onClick = onClick, onDeleteClick = onDelete) {
        Text("Tenggat waktu: ${formatDate(item.selectedDate)}", style = MaterialTheme.typography.bodySmall)
        Text("Sisa Hari: ${item.daysLeft}", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun DelayedItemView(item: DashboardItemModel, onClick: (DashboardItemModel) -> Unit, onDelete: (DashboardItemModel) -> Unit) {
    BaseItemView(item = item, onClick = onClick, onDeleteClick = onDelete) {
        Text("Tanggal Selesai: ${formatDate(item.dateDone)}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.daysOfWork} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
internal fun HistoryItemView(item: DashboardItemModel) {
    BaseItemView(item = item, onClick = null, onDeleteClick = null) {
        Text("Tanggal Selesai: ${formatDate(item.dateDone)}", style = MaterialTheme.typography.bodySmall)
        Text("Tanggal Pembayaran: ${formatDate(item.datePayed)}", style = MaterialTheme.typography.bodySmall)
        Text("Lama Pengerjaan: ${item.daysOfWork} Hari", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun BaseItemView(
    item: DashboardItemModel,
    onClick: ((DashboardItemModel) -> Unit)?,
    onDeleteClick: ((DashboardItemModel) -> Unit)?,
    additionalContent: @Composable () -> Unit
) {
    var showDoneDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }

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
                IconButton(onClick = { showDoneDialog = true }) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "Done")
                }
            }
            if (onDeleteClick != null) {
                IconButton(onClick = { showDeleteDialog = true }) {
                    Icon(imageVector = Icons.Default.Delete , contentDescription = "Delete")
                }
            }
        }
        // Checkbox Confirmation Dialog
        if (showDoneDialog) {
            AlertDialog(
                onDismissRequest = { showDoneDialog = false },
                title = { Text("Ubah Status Pesanan?") },
                text = {
                    if (!item.isDone) {
                        Text("Ubah status pesanan ke Belum Bayar jika barang sudah jadi dan tinggal menunggu pembayaran")
                    } else {
                        Text("Selesaikan pesanan jika pesanan sudah dibayar")
                    }
                },
                confirmButton = {
                    TextButton(onClick = {
                        if (!item.isDone) {
                            onClick?.invoke(item.copy(isDone = true, isPayed = false))
                        } else {
                            onClick?.invoke(item.copy(isPayed = true))
                        }
                        showDoneDialog = false
                    }) {
                        Text("Ya")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDoneDialog = false }) {
                        Text("Tidak")
                    }
                }
            )
        }
        // Delete Confirmation Dialog
        if (showDeleteDialog) {
            AlertDialog(
                onDismissRequest = { showDeleteDialog = false },
                title = { Text("Hapus Pesanan") },
                text = { Text("Yakin ingin menghapus pesanan ini?") },
                confirmButton = {
                    TextButton(onClick = {
                        onDeleteClick?.invoke(item)
                        showDeleteDialog = false
                    }) {
                        Text("Hapus")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDeleteDialog = false }) {
                        Text("Batal")
                    }
                }
            )
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