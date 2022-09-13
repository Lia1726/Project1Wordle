package com.example.project1wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.project1wordle.FourLetterWordList.getRandomFourLetterWord

//Pick Random Word

class MainActivity : AppCompatActivity() {
    private lateinit var wordToGuess : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wordToGuess = getRandomFourLetterWord()

        //User Guess
        val userGuesses = findViewById<EditText>(R.id.userGuess)
        val actualWord = findViewById<TextView>(R.id.givenWord)
        actualWord.text = wordToGuess
        val guessButton = findViewById<Button>(R.id.buttonGuess)
        var counter = 0

        //Visibility of outputs
        val revealGuess1 = findViewById<TextView>(R.id.guess1)
        val revealGuess2 = findViewById<TextView>(R.id.guess2)
        val revealGuess3 = findViewById<TextView>(R.id.guess3)
        val revealCheck1 = findViewById<TextView>(R.id.check1)
        val revealCheck2 = findViewById<TextView>(R.id.check2)
        val revealCheck3 = findViewById<TextView>(R.id.check3)

        val checkGuess1 = findViewById<TextView>(R.id.guessDisplay1)
        val checkGuess2 = findViewById<TextView>(R.id.guessDisplay2)
        val checkGuess3 = findViewById<TextView>(R.id.guessDisplay3)

        val checkDisplay1 = findViewById<TextView>(R.id.checkDisplay1)
        val checkDisplay2 = findViewById<TextView>(R.id.checkDisplay2)
        val checkDisplay3 = findViewById<TextView>(R.id.checkDisplay3)

        guessButton.setOnClickListener {
            val userEnteredWord = userGuesses.text.toString().uppercase()
            if (checkDisplay1.text.equals("OOOO") || checkDisplay1.text.equals("OOOO") || checkDisplay1.text.equals("OOOO")){
                actualWord.visibility = View.VISIBLE
            }
            else if (counter == 0) {
                counter++;
                revealGuess1.visibility = View.VISIBLE
                checkGuess1.text = userEnteredWord
                checkGuess1.visibility = View.VISIBLE
                revealCheck1.visibility = View.VISIBLE
                checkDisplay1.text = checkGuess1.toString()
                checkDisplay1.text = checkGuess(userEnteredWord)
                checkDisplay1.visibility = View.VISIBLE
                userGuesses.text.clear()
            }

            else if (counter == 1) {
                counter++;
                revealGuess2.visibility = View.VISIBLE
                checkGuess2.text = userEnteredWord
                checkGuess2.visibility = View.VISIBLE
                revealCheck2.visibility = View.VISIBLE
                checkDisplay2.text = checkGuess2.toString()
                checkDisplay2.text = checkGuess(userEnteredWord)
                checkDisplay2.visibility = View.VISIBLE
                userGuesses.text.clear()
            }
            else if (counter == 2) {
                counter++;
                revealGuess3.visibility = View.VISIBLE
                checkGuess3.text = userEnteredWord
                checkGuess3.visibility = View.VISIBLE
                revealCheck3.visibility = View.VISIBLE
                checkDisplay3.text = checkGuess3.toString()
                checkDisplay3.text = checkGuess(userEnteredWord)
                checkDisplay3.visibility = View.VISIBLE
                userGuesses.text.clear()
                actualWord.visibility = View.VISIBLE
            }
        }

    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}