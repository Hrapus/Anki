package com.example.anki

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Datas {

    private val d = MutableLiveData<List<Word>>()
    private var mList: MutableList<Word> = mutableListOf<Word>()
    private var id = 0


    init {
        for (i in 0 .. 10){
            val word = Word(id ,"The students agree they have too much homework #$i ID: $id")
            mList.add(word)
            id++
        }
        d.value = mList
    }

    fun getList(): LiveData<List<Word>> {
        return d
    }

    fun deleteWord(index: Int){
        mList.removeAt(index)
        mList.sortByDescending { it.id }
        d.value = mList
    }

    fun addWord(word: String) {
        id++
        mList.add(Word(id, word))
        mList.sortByDescending { it.id }
        d.value = mList
    }

}