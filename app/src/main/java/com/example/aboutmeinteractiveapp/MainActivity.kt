package com.example.aboutmeinteractiveapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutmeinteractiveapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var myName : MyName = MyName("Professor Berlin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName=myName;

        binding.doneButton.setOnClickListener({
            addTextView(it)
        })

        binding.nameTextView.setOnClickListener({
            updateTextView()
        })
    }

    private fun addTextView(view: View){
        binding.apply {
            myName?.nickName=binding.nameEditView.text.toString()
            invalidateAll()
            binding.nameTextView.visibility=View.VISIBLE
            binding.nameEditView.visibility=View.GONE
            binding.doneButton.visibility=View.GONE }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateTextView(){
        binding.apply {
            binding.nameEditView.visibility = View.VISIBLE
            binding.doneButton.visibility = View.VISIBLE
            binding.nameTextView.visibility = View.GONE

            binding.nameEditView.requestFocus()
        }

        val imm =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nameEditView,0)

    }
}