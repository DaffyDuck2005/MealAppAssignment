package com.example.mealapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.lowercase
import kotlin.text.trim

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Gemini took original code created and output code below in organised working condition.
        //Youtube video : https://www.youtube.com/watch?v=VpDBP-4HUyg&list=PLQkwcJG4YTCRSQikwhtoApYs9ij_Hc5Z9&index=14
        //Gemini assisted in code for listing randomly.

        val timeEditText = findViewById<EditText>(R.id.edtPTime)
        val mealsTextView = findViewById<TextView>(R.id.edtTMeals)
        val suggestButton = findViewById<Button>(R.id.btnSuggest)
        val resetButton = findViewById<Button>(R.id.btnReset)

        val topicListMorning = listOf("Eggs and Toast", "Oats and Yogurt", "Coffee", "Cereal", "Protein Shake", "Eggs and Bacon", "Bran Muffins", "Avocado on Toast")
        val topicListMidMorning = listOf("frittata", "spinach quiche", "Coffee Cake", "Breakfast Burrito", "Tofu Scramble", "omelette", "Hash Browns")
        val topicListAfternoon = listOf("Burgers", "Chicken and Rice", "Lamb chops", "Fish and Chips", "Lamb and vegetables", "Chicken fillet and chips", "Hot Dog Roll")
        val topicListAfternoonSnack = listOf("Peanuts", "Raisins", "PBJ Sandwich", "Cream crackers and cheese", "Strips and chips", "Fruits")
        val topicListDinner = listOf("Steak and Mash", "Chicken Curry", "Prawns and Calamari", "Fish and Broccoli", "Braai", "Full Chicken Meal", "Mutton Breyani")
        val topicListAfterDinner = listOf("Ice Cream", "Custard", "Pancakes", "Waffles", "Jelly", "Cheesecake", "Tiramisu")


        suggestButton.setOnClickListener {
            val inputTime = timeEditText.text.toString().trim().lowercase() // Get and normalize input
            val selectedTopic = when (inputTime) {
                "morning" -> topicListMorning.random()
                "mid morning" -> topicListMidMorning.random()
                "afternoon" -> topicListAfternoon.random()
                "mid afternoon" -> topicListAfternoonSnack.random()
                "dinner" -> topicListDinner.random()
                "after dinner" -> topicListAfterDinner.random()
                else -> "Input Correct Time"
                //Each time given has different list of topics for the meal choices.
                //Each list is selected to pick a random option for the inputted Time.
            }
            mealsTextView.text = selectedTopic // Update the TextView
        }
        resetButton.setOnClickListener {
            timeEditText.text.clear()
            mealsTextView.text = ""
            // Reset Time EditText and Meals TextView for new input.
        }
    }
}