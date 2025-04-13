package com.example.eweek05a.model

sealed class ImageUri { // sealed class 상속 받는 class가 파일 내부에 존재
    data class ResImage(val resID:Int) : ImageUri()
    data class WebImage(val webUrl:String) : ImageUri()
}