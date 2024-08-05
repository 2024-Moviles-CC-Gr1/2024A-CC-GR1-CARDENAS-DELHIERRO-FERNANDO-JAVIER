package com.example.telegramrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CallsActivity : AppCompatActivity() {

    private lateinit var recyclerViewCalls: RecyclerView
    private lateinit var callAdapter: CallAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calls)

        recyclerViewCalls = findViewById(R.id.recycler_view_calls)
        recyclerViewCalls.layoutManager = LinearLayoutManager(this)

        val callList = listOf(
            Call("John Doe", "10:00 AM", CallType.INCOMING),
            Call("Jane Smith", "2:00 PM", CallType.MISSED)
            // Agrega más llamadas aquí
        )

        callAdapter = CallAdapter(callList)
        recyclerViewCalls.adapter = callAdapter
    }
}
