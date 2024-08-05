package com.example.telegramrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telegramrecyclerview.ContactAdapter
import com.example.telegramrecyclerview.Contact

class ContactsActivity : AppCompatActivity() {

    private lateinit var recyclerViewContacts: RecyclerView
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        recyclerViewContacts = findViewById(R.id.recycler_view_contacts)
        recyclerViewContacts.layoutManager = LinearLayoutManager(this)

        val contactList = listOf(
            Contact("John Doe", "+1234567890"),
            Contact("Jane Smith", "+0987654321")
            // Agrega más contactos aquí
        )

        contactAdapter = ContactAdapter(contactList)
        recyclerViewContacts.adapter = contactAdapter
    }
}