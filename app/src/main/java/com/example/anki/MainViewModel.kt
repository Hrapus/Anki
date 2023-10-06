package com.example.anki

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val repos = Datas.getList()

    fun returnList(): LiveData<List<String>>{
        return repos
    }

}