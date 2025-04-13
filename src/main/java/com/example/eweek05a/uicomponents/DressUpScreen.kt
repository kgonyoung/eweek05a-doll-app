package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.viewmodel.DollViewModel

@Composable
fun DressUpScreen(viewModel: DollViewModel = viewModel()) {
    val dollList = viewModel.dollList
    val orientation = LocalConfiguration.current.orientation

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "202111247 김곤용",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        // ⬇ 기존 레이아웃 분기
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // 인형
                DollPreviewBox(
                    dollParts = dollList,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
                Spacer(modifier = Modifier.width(16.dp))
                // 체크박스들
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    for (i in dollList.indices step 2) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            DollPartToggle(
                                doll = dollList[i],
                                onStatusChange = { newStatus ->
                                    viewModel.updateDollStatus(i, newStatus)
                                },
                                modifier = Modifier.weight(1f)
                            )
                            if (i + 1 < dollList.size) {
                                DollPartToggle(
                                    doll = dollList[i + 1],
                                    onStatusChange = { newStatus ->
                                        viewModel.updateDollStatus(i + 1, newStatus)
                                    },
                                    modifier = Modifier.weight(1f)
                                )
                            } else {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        } else {
            Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                DollPreviewBox(
                    dollParts = dollList,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))

                for (i in dollList.indices step 2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        DollPartToggle(
                            doll = dollList[i],
                            onStatusChange = { newStatus ->
                                viewModel.updateDollStatus(i, newStatus)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        if (i + 1 < dollList.size) {
                            DollPartToggle(
                                doll = dollList[i + 1],
                                onStatusChange = { newStatus ->
                                    viewModel.updateDollStatus(i + 1, newStatus)
                                },
                                modifier = Modifier.weight(1f)
                            )
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}