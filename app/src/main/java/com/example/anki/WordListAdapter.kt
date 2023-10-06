package com.example.anki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    var wordList = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class WordViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val tvWord = view.findViewById<TextView>(R.id.tv_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = R.layout.word_for_list
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList[position]
        holder.tvWord.text = word
    }
}