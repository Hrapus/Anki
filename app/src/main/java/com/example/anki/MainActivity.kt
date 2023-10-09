package com.example.anki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var wordListAdapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycleView()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.returnList().observe(this){
            Log.d("test", it.toString())
            wordListAdapter.wordList = it
        }
    }

    private fun setupRecycleView(){
        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        wordListAdapter = WordListAdapter()
        rvList.adapter = wordListAdapter

        wordListAdapter.onWordClickListener = object : WordListAdapter.OnWordClickListener {
            override fun onWordClick(word: String) {
            }

        }
    }
}