package com.example.anki

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {


    var wordList = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onWordClickListener: OnWordClickListener? = null

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

    interface OnWordClickListener {
        fun onWordClick()
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = wordList[position]
        holder.tvWord.text = word

        holder.view.setOnClickListener {
            onWordClickListener?.onWordClick()
            holder.lLayout.setBackgroundColor(Color.CYAN)
        }

    }
}
