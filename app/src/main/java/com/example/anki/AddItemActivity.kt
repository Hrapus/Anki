package com.example.anki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class AddItemActivity : AppCompatActivity() {

    lateinit var newWord : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        val button = findViewById<Button>(R.id.save_button)
        val inputText = findViewById<TextInputEditText>(R.id.et_word)

        button.setOnClickListener {
            newWord = inputText.text.toString()
            val i = Intent()
            i.putExtra("key1", newWord)
            setResult(RESULT_OK, i)
            finish()
        }
    }
}