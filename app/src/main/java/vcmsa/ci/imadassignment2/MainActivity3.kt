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
            "The Anglo-Zulu War took place in 1912, and it was fought between the British Empire and the Zulu Kingdom.",
            " The Battle of Blood River in 1838 was a significant conflict between the Voortrekkers and the Zulu Kingdom.",
            "The 1994 elections were the first in South Africa where people of all races were allowed to vote.",
            "The Boers were Dutch settlers who first arrived in South Africa in the late 18th century, eventually establishing the Union of South Africa in 1910.",
            "The apartheid policy was officially ended by the South African government in 1989."
        )

        val answers = booleanArrayOf(false, true, true, false, false)

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