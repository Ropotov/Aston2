package com.example.aston2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aston2.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val count = intent.getIntExtra(MainActivity.PUT_EXTRA, 0)

        binding.count.text = count.toString()
    }
}