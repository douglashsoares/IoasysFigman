package br.com.douglas.ioasysfigman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtError = findViewById<AppCompatTextView>(R.id.txtError)

        val button = findViewById<MaterialButton>(R.id.btnEnter)

        button.setOnClickListener{
            val intent = Intent(this,BookListActivity::class.java)
            startActivity(intent)
        }
    }
}