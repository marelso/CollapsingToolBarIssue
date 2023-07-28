package com.marelso.collapsingtoolbarissue.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.marelso.collapsingtoolbarissue.data.Filter
import com.marelso.collapsingtoolbarissue.databinding.ItemFilterBinding
import java.lang.RuntimeException

class FilterAdapter(private val dataList: List<Filter>) :
    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private var binding: ItemFilterBinding? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.binding = ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return this.binding?.let { ViewHolder(it.root) } ?: throw RuntimeException("AA")
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val chip: Chip? = binding?.filter
        fun bind(filter: Filter) {
            chip?.text = filter.name
        }
    }

}