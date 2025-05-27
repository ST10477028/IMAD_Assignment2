package vcmsa.ci.imadassignment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val questions = arrayOf(
            "In 1990, Nelson Mandela was released from prison.",
            "In 1903, the first woman won the Nobel Prize.",
            "The Mona Lisa was painted by Leonardo Da Vinci.",
            "The first person to walk on the moon was Ronaldo",
            "The first car was made in 300BC"
        )

        val answers = booleanArrayOf(true, true, true, false, false)

        val score = intent.getIntExtra("score", 0)

        val scoreTextView = findViewById<TextView>(R.id.sTextView)
        val feedbackTextView = findViewById<TextView>(R.id.fTextView2)
        val reviewTextView = findViewById<TextView>(R.id.qTextView2)
        val reviewButton = findViewById<Button>(R.id.rBtn)
        val exitButton = findViewById<Button>(R.id.eBtn)
// display score
        scoreTextView.text = "Your score: $score / 5"

        feedbackTextView.text = when (score) {
            in 3..5 -> "Great job!"
            in 1..2 -> "Keep practicing!"
            else -> "Ahh mahn"
        }
//displays the review of questions and answers
        reviewButton.setOnClickListener {
            val builder = StringBuilder()
            for (i in questions.indices) {
                builder.append("Q${i + 1}: ${questions[i]}\n")
                builder.append("Correct Answer: ${answers[i]}\n\n")
            }
            reviewTextView.text = builder.toString()
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}