package vcmsa.ci.imadassignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    //array to store history questions
    val questions = arrayOf(
        "The Anglo-Zulu War took place in 1912, and it was fought between the British Empire and the Zulu Kingdom.",
        " The Battle of Blood River in 1838 was a significant conflict between the Voortrekkers and the Zulu Kingdom.",
        "The 1994 elections were the first in South Africa where people of all races were allowed to vote.",
        "The Boers were Dutch settlers who first arrived in South Africa in the late 18th century, eventually establishing the Union of South Africa in 1910.",
        "The apartheid policy was officially ended by the South African government in 1989."
    )

    //array to store true/false answers which are boolean
    val answers = booleanArrayOf(false , true, true, false, false)

    //variable declaration which also initializes it to 0
    var score = 0
    var currentIndex = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

            //variable declarations for textviews and buttons which will be used in the app
            val questionText = findViewById<TextView>(R.id.qTextView)
            val feedbackText = findViewById<TextView>(R.id.fTextView)
            val trueBtn = findViewById<Button>(R.id.tBtn)
            val falseBtn = findViewById<Button>(R.id.fBtn)
            val nextBtn = findViewById<Button>(R.id.nBtn)

            //updateQuestion() updates the UI to show the current question and  resets the feedback and buttons for the next interaction
            fun updateQuestion() {
                questionText.text = questions[currentIndex]//sets text of UI element
                feedbackText.text = ""//clears  feedback texts
                trueBtn.isEnabled = true//enables the button
                falseBtn.isEnabled = true//enables the button
            }

            //updates UI
            updateQuestion()

            //when button is pressed, the app will determine whether answer is correct
            trueBtn.setOnClickListener {
                checkAnswer(true)
            }

            falseBtn.setOnClickListener {
                checkAnswer(false)
            }

            //the next button
            nextBtn.setOnClickListener {
                currentIndex++
                if (currentIndex < questions.size) {
                    updateQuestion()
                } else {
                    val intent = Intent(this, MainActivity3::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent)
                    finish()
                }
            }
        }

        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = answers[currentIndex]
            if (userAnswer == correctAnswer) {
                score++
            }

            val feedbackText = findViewById<TextView>(R.id.fTextView)
            if (userAnswer == correctAnswer) {
                feedbackText.text = "Correct!"
            } else {
                feedbackText.text = "Incorrect!"
            }

            // Disable the buttons after selection
            findViewById<Button>(R.id.tBtn).isEnabled = false
            findViewById<Button>(R.id.fBtn).isEnabled = false
        }
    }