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
            Call("Jane Smith", "2:00 PM", CallType.MISSED),
            Call("Alice Johnson", "9:00 AM", CallType.OUTGOING),
            Call("Bob Brown", "11:30 AM", CallType.INCOMING),
            Call("Charlie Davis", "3:15 PM", CallType.MISSED),
            Call("David Evans", "6:45 PM", CallType.INCOMING),
            Call("Eva Foster", "8:20 AM", CallType.OUTGOING),
            Call("Frank Green", "12:00 PM", CallType.MISSED),
            Call("Grace Harris", "4:50 PM", CallType.INCOMING),
            Call("Hannah Hill", "10:10 AM", CallType.OUTGOING),
            Call("Ian Jackson", "2:25 PM", CallType.MISSED),
            Call("Judy King", "5:30 PM", CallType.INCOMING),
            Call("Kevin Lee", "7:00 AM", CallType.OUTGOING),
            Call("Laura Martin", "9:40 AM", CallType.MISSED),
            Call("Mike Nelson", "1:55 PM", CallType.INCOMING),
            Call("Nina Owens", "4:10 PM", CallType.OUTGOING),
            Call("Oscar Perez", "6:35 PM", CallType.MISSED),
            Call("Paula Quinn", "8:50 AM", CallType.INCOMING),
            Call("Quincy Reed", "10:05 AM", CallType.OUTGOING),
            Call("Rachel Scott", "12:30 PM", CallType.MISSED),
            Call("Sam Taylor", "3:45 PM", CallType.INCOMING),
            Call("Tina Underwood", "5:15 PM", CallType.OUTGOING),
            Call("Uma Vance", "7:25 AM", CallType.MISSED),
            Call("Victor White", "9:50 AM", CallType.INCOMING),
            Call("Wendy Young", "11:20 AM", CallType.OUTGOING),
            Call("Xander Brown", "2:40 PM", CallType.MISSED),
            Call("Yvonne Clark", "4:55 PM", CallType.INCOMING),
            Call("Zachary Adams", "7:10 AM", CallType.OUTGOING),
            Call("Amy Bell", "8:35 AM", CallType.MISSED),
            Call("Brian Carter", "10:00 AM", CallType.INCOMING),
            Call("Cindy Dixon", "12:45 PM", CallType.OUTGOING),
            Call("Derek Edwards", "3:20 PM", CallType.MISSED),
            Call("Ella Fisher", "5:50 PM", CallType.INCOMING),
            Call("Fred Garcia", "7:30 AM", CallType.OUTGOING),
            Call("Gina Hall", "9:15 AM", CallType.MISSED),
            Call("Henry Ingram", "11:05 AM", CallType.INCOMING),
            Call("Ivy Jenkins", "1:25 PM", CallType.OUTGOING),
            Call("Jack Knight", "4:00 PM", CallType.MISSED),
            Call("Karen Logan", "6:15 PM", CallType.INCOMING),
            Call("Liam Murphy", "7:45 AM", CallType.OUTGOING),
            Call("Mona Nash", "9:25 AM", CallType.MISSED),
            Call("Nick Oliver", "11:55 AM", CallType.INCOMING)

            // Agrega más llamadas aquí
        )

        callAdapter = CallAdapter(callList)
        recyclerViewCalls.adapter = callAdapter
    }
}
