package com.marelso.collapsingtoolbarissue.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.marelso.collapsingtoolbarissue.data.Content
import com.marelso.collapsingtoolbarissue.databinding.ItemContentBinding
import java.lang.RuntimeException

class ContentAdapter (private val dataList: List<Content>) :
    RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    private var binding: ItemContentBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return this.binding?.let { ViewHolder(it.root) } ?: throw RuntimeException("AA")
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val content: ConstraintLayout? = binding?.content
        private val name: TextView? = binding?.name
        fun bind(content: Content) {
            name?.text = content.name
        }
    }

}