package com.example.eweek05a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eweek05a.model.Doll
import com.example.eweek05a.model.Status


@Composable
fun DollPartToggle(
    doll: Doll,
    onStatusChange: (Status) -> Unit,
    modifier: Modifier = Modifier // modifier 추가
) {
    Row(
        modifier = modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = (doll.visuality == Status.VISIBLE),
            onCheckedChange = {
                onStatusChange(if (it) Status.VISIBLE else Status.HIDDEN)
            }
        )
        Text(text = doll.text, style = MaterialTheme.typography.bodyLarge)
    }
}