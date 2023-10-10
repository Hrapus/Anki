package com.example.anki

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var wordListAdapter: WordListAdapter
    private lateinit var addButton: FloatingActionButton

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val newWord = result.data?.getStringExtra("key1")
            viewModel.addWord(newWord.toString())
            Log.d("test", newWord.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addButton = findViewById(R.id.button_add_word)


        setupRecycleView()
        addButton.setOnClickListener {
            val intent = Intent(this, AddItemActivity::class.java)
            startForResult.launch(intent)
        }

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

        wordListAdapter.onWordClickListener = {
            Log.d("test", it)
        }

        swipe(rvList)
    }

    private fun swipe(rvList: RecyclerView?) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val word = wordListAdapter.wordList[viewHolder.adapterPosition]
                viewModel.deleteWord(viewHolder.adapterPosition)
            }

        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvList)
    }

}