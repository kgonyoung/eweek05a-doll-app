package com.example.eweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.eweek05a.R

object DollFactory {
    fun makeDollList()= mutableStateListOf<Doll>(
        Doll("arms", Status.HIDDEN, R.drawable.arms),
        Doll("shoes", Status.HIDDEN, R.drawable.shoes),
        Doll("ears", Status.HIDDEN, R.drawable.ears),
        Doll("eyes", Status.HIDDEN, R.drawable.eyes),
        Doll("eyebrows", Status.HIDDEN, R.drawable.eyebrows),
        Doll("glasses", Status.HIDDEN, R.drawable.glasses),
        Doll("hat", Status.HIDDEN, R.drawable.hat),
        Doll("mouth", Status.HIDDEN, R.drawable.mouth),
        Doll("mustache", Status.HIDDEN, R.drawable.mustache),
        Doll("nose", Status.HIDDEN, R.drawable.nose),
    )
}