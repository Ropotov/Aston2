package com.example.aston2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aston2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = 0

        binding.count.setOnClickListener {
            count++
            binding.textView.text = count.toString()
        }

        binding.sayHello.setOnClickListener {
            startActivity(Intent(
                this,
                HelloActivity::class.java
            ).putExtra(PUT_EXTRA, count))
        }
    }

    companion object{
        const val PUT_EXTRA = "count"
    }
}