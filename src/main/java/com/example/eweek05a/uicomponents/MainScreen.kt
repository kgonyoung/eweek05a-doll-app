package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.viewmodel.ImageViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, imageViewModel: ImageViewModel = viewModel()) {

    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    val scrollState = rememberScrollState()

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageList(imageList = imageList)
        }
    } else {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ImageList(imageList = imageList)
        }
    }
}

//    var img1State by rememberSaveable(stateSaver = ImageData.ImageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.BADGE,
//                likes = 50
//            )
//        )
//
//        Column {
//            ImageWithButton(image = img1State.state) {
//                ButtonWithBadge(likes = img1State.likes) {
//                    img1State = img1State.copy(likes = img1State.likes+1)
//                }
//            }
//        }
//
//        var img2State by rememberSaveable(stateSaver = ImageData.ImageSaver) { //미완
//            mutableStateOf(
//                ImageData(
//                    image = ImageUri.ResImage(R.drawable.img2),
//                    buttonType = ButtonType.Emoji,
//                    likes = 50,
//                    dislikes = 10
//                )
//            )
//
//            Column {
//                ImageWithButton(image = img1State.state) {
//                    ButtonWithBadge(likes = img1State.likes) {
//                        img1State = img1State.copy(likes = img1State.likes+1)
//                    }
//                }
//
//                ImageWithButton(image = img1State.state) {
//                    ButtonWithEmoji(
//                        likes = img2State.likes,
//                        dislikes = img2State.dislikes,
//                        onClickLikes = { img2State = img2State.copy(likes = img2State.likes+1) },
//                        onClickDislikes = { img2State = img2State.copy(dislikes = img2State.dislikes+1) }
//                    )
//                }
//
//            }

//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                ButtonType.EMOJI,
//                likes = 50,
//                dislikes = 20
//            )
//        )
