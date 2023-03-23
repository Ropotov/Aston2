package com.example.aston2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aston2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            count = it.getInt("count")
        }

        binding.textView.text = count.toString()
        binding.count.setOnClickListener {
            count++
            binding.textView.text = count.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }
}