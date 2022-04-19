package id.sharekom.intentexcercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val firstName = intent.getStringExtra(EXTRA_FIRST_NAME)
        val middleName = intent.getStringExtra(EXTRA_MIDDLE_NAME)
        val lastName = intent.getStringExtra(EXTRA_LAST_NAME)

        val fullName = "$firstName $middleName $lastName"

        val tvNameDescription = findViewById<TextView>(R.id.tv_name_description)
        tvNameDescription.text =
            getString(R.string.name_description, firstName, middleName, lastName, fullName)
    }

    companion object {
        const val EXTRA_FIRST_NAME = "extra_first_name"
        const val EXTRA_MIDDLE_NAME = "extra_middle_name"
        const val EXTRA_LAST_NAME = "extra_last_name"
    }
}