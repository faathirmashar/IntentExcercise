package id.sharekom.intentexcercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etFirst: EditText
    private lateinit var etMiddle: EditText
    private lateinit var etLast: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirst = findViewById(R.id.et_first)
        etMiddle = findViewById(R.id.et_middle)
        etLast = findViewById(R.id.et_last)

        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        btnSubmit.setOnClickListener {
            if (isInputEmpty()) {
                val bundle = Bundle()
                bundle.putString(DetailActivity.EXTRA_FIRST_NAME, etFirst.text.trim().toString())
                bundle.putString(DetailActivity.EXTRA_MIDDLE_NAME, etMiddle.text.trim().toString())
                bundle.putString(DetailActivity.EXTRA_LAST_NAME, etLast.text.trim().toString())

                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun isInputEmpty(): Boolean {
        if (etFirst.text.isEmpty()) {
            etFirst.error = "First name is required"
            return false
        }

        if (etMiddle.text.isEmpty()) {
            etMiddle.error = "Middle name is required"
            return false
        }

        if (etLast.text.isEmpty()) {
            etLast.error = "Last name is required"
            return false
        }

        return true
    }
}