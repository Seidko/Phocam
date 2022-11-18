package com.seidko.phomic.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seidko.phomic.R
import com.seidko.phomic.data.entities.Connection
import com.seidko.phomic.data.entities.ConnectionStatus


class ConnectionRecyclerAdapter(private var connectionArray: ArrayList<Connection>) :
    RecyclerView.Adapter<ConnectionRecyclerAdapter.ItemViewHolder>() {
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context.applicationContext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_connection, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.deviceName.text = this.connectionArray[position].name
        holder.icon
        holder.status.text = context.getString(
            when (this.connectionArray[position].status) {
                ConnectionStatus.Connecting -> R.string.status_connecting
                ConnectionStatus.InActive -> R.string.status_inactive
                ConnectionStatus.Active -> R.string.status_active
            }
        )
        holder.address.text = connectionArray[position].address

    }

    override fun getItemCount(): Int {
        return connectionArray.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val deviceName: TextView
        val status: TextView
        val address: TextView
        val icon: ImageView

        init {
            deviceName = itemView.findViewById(R.id.device_name)
            status = itemView.findViewById(R.id.connection_status)
            address = itemView.findViewById(R.id.address)
            icon = itemView.findViewById(R.id.status_icon)
        }
    }
}