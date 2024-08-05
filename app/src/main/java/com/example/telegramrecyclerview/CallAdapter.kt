package com.example.telegramrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CallAdapter(private val callList: List<Call>) :
    RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    class CallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val callerNameTextView: TextView = itemView.findViewById(R.id.caller_name)
        val callTimeTextView: TextView = itemView.findViewById(R.id.call_time)
        val callTypeTextView: TextView = itemView.findViewById(R.id.call_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_call, parent, false)
        return CallViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val currentCall = callList[position]
        holder.callerNameTextView.text = currentCall.callerName
        holder.callTimeTextView.text = currentCall.callTime
        holder.callTypeTextView.text = currentCall.callType.name
    }

    override fun getItemCount() = callList.size
}