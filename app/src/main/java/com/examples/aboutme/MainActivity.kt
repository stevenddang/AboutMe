package com.examples.aboutme

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var doneButton: Button
    lateinit var nicknameTextView: TextView
    lateinit var nickname: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nickname = findViewById(R.id.nickname_text)
        nicknameTextView = findViewById(R.id.nickname_text_view)

        doneButton = findViewById<Button>(R.id.done_button)

        doneButton.setOnClickListener{
            addNickname(it)
        }

    }

    @SuppressLint("SetTextI18n")
    private fun addNickname(view: View){
        val nickNameText = nicknameTextView.text

        nickname.text = nickNameText

        nickname.visibility = View.VISIBLE
        doneButton.visibility = View.GONE
        nicknameTextView.visibility = View.GONE


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
