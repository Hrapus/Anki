package com.example.anki

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Datas {

    private val d = MutableLiveData<List<String>>()
    private var mList: MutableList<String> = mutableListOf<String>()

    init {
        for (i in 0 .. 10){
            val word = "The students agree they have too much homework #$i"
            mList.add(word)
        }
        d.value = mList
    }

    fun getList(): LiveData<List<String>> {
        return d
    }

    fun deleteWord(index: Int){
        mList.removeAt(index)
        d.value = mList
    }

    fun addWord(word: String) {
        mList.add(word)
        d.value = mList
    }

}