package com.neoutils.hightlight.example.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neoutils.hightlight.example.view.databinding.ActivityTextViewBinding

class TextViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}