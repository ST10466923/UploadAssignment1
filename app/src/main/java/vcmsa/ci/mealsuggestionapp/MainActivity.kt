package vcmsa.ci.mealsuggestionapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val suggestButton = findViewById<Button>(R.id.suggestButton)

        suggestButton.setOnClickListener {
            val time = timeInput.text.toString().toIntOrNull()
            val timeText = timeInput.text.toString()

            if (timeText.isEmpty()) {
                timeInput.error = "Please enter a time!" //the user must input a time
                return@setOnClickListener
            }

            if (time == null || time !in 0..24) {
                timeInput.error = "Enter a valid time (0-24)!"
                resultText.text = "Invalid input. Please try again." //an error is displayed after the user input a negative number or a number bigger than 24
                return@setOnClickListener
            }

            if (time in 0..24) {
                val mealSuggestion = when (time)  {
                    in 5..10 -> "Bacon and Egg"
                    in 11..12 -> "Banana or pear"
                    in 13..15 -> "Burger"
                    in 16..18 -> "Cake"
                    in 19..21 -> "Spaghetti and Meatballs"
                    in 22..24 -> "Waffles"
                    else -> "Just a glass of water"
                }
                resultText.text = "Meal Suggestion: $mealSuggestion" //display what the user will eat based on his/her time input in the timeInput text
            } else {
                resultText.text = "Please enter a valid time (0-24)"
            }
        }

























        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}