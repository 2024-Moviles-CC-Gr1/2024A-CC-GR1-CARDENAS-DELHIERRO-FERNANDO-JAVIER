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
            Contact("Jane Smith", "+0987654321"),
            Contact("Alice Johnson", "+1122334455"),
            Contact("Bob Brown", "+2233445566"),
            Contact("Charlie Davis", "+3344556677"),
            Contact("David Evans", "+4455667788"),
            Contact("Eva Foster", "+5566778899"),
            Contact("Frank Green", "+6677889900"),
            Contact("Grace Harris", "+7788990011"),
            Contact("Hannah Hill", "+8899001122"),
            Contact("Ian Jackson", "+9900112233"),
            Contact("Judy King", "+0011223344"),
            Contact("Kevin Lee", "+1122334466"),
            Contact("Laura Martin", "+2233445577"),
            Contact("Mike Nelson", "+3344556688"),
            Contact("Nina Owens", "+4455667799"),
            Contact("Oscar Perez", "+5566778800"),
            Contact("Paula Quinn", "+6677889911"),
            Contact("Quincy Reed", "+7788990022"),
            Contact("Rachel Scott", "+8899001133"),
            Contact("Sam Taylor", "+9900112244"),
            Contact("Tina Underwood", "+0011223355"),
            Contact("Uma Vance", "+1122334477"),
            Contact("Victor White", "+2233445588"),
            Contact("Wendy Young", "+3344556699"),
            Contact("Xander Brown", "+4455667800"),
            Contact("Yvonne Clark", "+5566778911"),
            Contact("Zachary Adams", "+6677889022"),
            Contact("Amy Bell", "+7788990133"),
            Contact("Brian Carter", "+8899001244"),
            Contact("Cindy Dixon", "+9900112355"),
            Contact("Derek Edwards", "+0011223466"),
            Contact("Ella Fisher", "+1122334588"),
            Contact("Fred Garcia", "+2233445699"),
            Contact("Gina Hall", "+3344556700"),
            Contact("Henry Ingram", "+4455667811"),
            Contact("Ivy Jenkins", "+5566778922"),
            Contact("Jack Knight", "+6677889133"),
            Contact("Karen Logan", "+7788990244"),
            Contact("Liam Murphy", "+8899001355"),
            Contact("Mona Nash", "+9900112466"),
            Contact("Nick Oliver", "+0011223577"),
            Contact("Olivia Parker", "+1122334699"),
            Contact("Paul Roberts", "+2233446800")
            // Agrega más contactos aquí
        )

        contactAdapter = ContactAdapter(contactList)
        recyclerViewContacts.adapter = contactAdapter
    }
}