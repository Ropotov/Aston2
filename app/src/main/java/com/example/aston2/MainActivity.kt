package com.example.aston2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.example.aston2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openWebSite.setOnClickListener {
            openWebSite()
        }

        binding.openLocation.setOnClickListener {
            openLocation()
        }

        binding.shareText.setOnClickListener {
            shareText()
        }

        binding.takePicture.setOnClickListener {
            takeAPictures()
        }
    }

    private fun openWebSite() {
        val uri = Uri.parse(binding.webSite.text.toString())
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    private fun openLocation() {
        val uri = Uri.parse("geo:0,0")
            .buildUpon().appendQueryParameter("q", binding.location.text.toString()).build()
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
    private fun shareText(){
        ShareCompat.IntentBuilder(this)
            .setType("text/plain")
            .setText(binding.text.text.toString())
            .startChooser()
    }

    private fun takeAPictures(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}

