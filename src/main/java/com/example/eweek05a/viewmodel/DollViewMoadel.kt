package com.example.eweek05a.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.eweek05a.model.Doll
import com.example.eweek05a.model.DollFactory
import com.example.eweek05a.model.Status

class DollViewModel : ViewModel() {

    // 내부 상태 보관
    private val _dollList = mutableStateListOf<Doll>().apply {
        addAll(DollFactory.makeDollList())
    }

    // 외부에서는 읽기만 가능
    val dollList: List<Doll> get() = _dollList

    // 특정 인형 부위 상태 업데이트
    fun updateDollStatus(index: Int, newStatus: Status) {
        _dollList[index] = _dollList[index].copy(visuality = newStatus)
    }
}
