package com.example.anki

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Datas {

    private val d = MutableLiveData<List<String>>()

    init {
        val mList = mutableListOf<String>()
        for (i in 0 .. 10){
            val word = "The students agree they have too much homework #$i"
            mList.add(word)
        }
        d.value = mList
    }

    fun getList(): LiveData<List<String>> {
        return d
    }

}