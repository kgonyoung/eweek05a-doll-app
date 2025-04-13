package com.example.eweek05a.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.eweek05a.R
import com.example.eweek05a.model.Doll
import com.example.eweek05a.model.Status

@Composable
fun DollPreviewBox(
    dollParts: List<Doll>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        // 1. body.png는 항상 표시
        Image(
            painter = painterResource(id = R.drawable.body),
            contentDescription = "Body",
            contentScale = ContentScale.Fit,
            modifier = Modifier.matchParentSize()
        )

        // 2. 나머지는 상태에 따라 조건부 표시
        dollParts.forEach { doll ->
            if (doll.visuality == Status.VISIBLE) {
                Image(
                    painter = painterResource(id = doll.img),
                    contentDescription = doll.text,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.matchParentSize()
                )
            }
        }
    }
}
