package vcmsa.ci.imadassignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //The start button
        val startButton = findViewById<Button>(R.id.stBtn)

        //set on click listener links the button to the desired function
        startButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)//links the two activities
            startActivity(intent)
            finish()
        }
    }
}