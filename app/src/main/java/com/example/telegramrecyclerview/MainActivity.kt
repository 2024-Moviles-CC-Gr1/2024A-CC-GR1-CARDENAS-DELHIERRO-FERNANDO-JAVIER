package com.example.telegramrecyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var buttonContacts: Button
    private lateinit var buttonCalls: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonContacts = findViewById(R.id.button_contacts)
        buttonCalls = findViewById(R.id.button_calls)

        buttonContacts.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }

        buttonCalls.setOnClickListener {
            val intent = Intent(this, CallsActivity::class.java)
            startActivity(intent)
        }
    }

}


