package com.examples.aboutme

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.examples.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName(name = "Steven Dang")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = this.myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

    }

    @SuppressLint("SetTextI18n")
    private fun addNickname(view: View) {

        binding.apply {
            this.myName?.nickname = nicknameTextView.text.toString()
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            nicknameTextView.visibility = View.GONE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
