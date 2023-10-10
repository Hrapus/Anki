package com.example.anki

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {


    var wordList = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onWordClickListener: ((String) -> Unit)? = null

    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvWord = view.findViewById<TextView>(R.id.tv_word)
        val lLayout = view.findViewById<LinearLayout>(R.id.l_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = R.layout.word_for_list
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onViewRecycled(holder: WordViewHolder) {
        super.onViewRecycled(holder)
        holder.lLayout.setBackgroundResource(R.color.purple_200)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList[position]
        holder.tvWord.text = word

        holder.view.setOnClickListener {
            onWordClickListener?.invoke(word)
            holder.lLayout.setBackgroundColor(Color.CYAN)
        }
    }
}
