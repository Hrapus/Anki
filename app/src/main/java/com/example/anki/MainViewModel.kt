package com.example.anki

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val repos = Datas.getList()

    fun returnList(): LiveData<List<Word>>{
        return repos
    }

    fun deleteWord(index:Int){
        Datas.deleteWord(index)
    }

    fun addWord(word:String){
        Datas.addWord(word)
    }

}