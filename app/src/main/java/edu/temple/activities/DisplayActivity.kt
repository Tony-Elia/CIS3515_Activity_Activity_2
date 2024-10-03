package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
        lyricsDisplayTextView.apply {
            textSize = result?.data?.getIntExtra("textSize", 24)?.toFloat() ?: 24F
        }
    }

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)
        lyricsDisplayTextView = findViewById<TextView>(R.id.lyricsDisplayTextView)

        textSizeSelectorButton.setOnClickListener {
            launcher.launch(Intent(this, TextSizeActivity::class.java))
        }
    }
}