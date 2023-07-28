package com.marelso.collapsingtoolbarissue.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.marelso.collapsingtoolbarissue.data.Filter
import com.marelso.collapsingtoolbarissue.databinding.ItemFilterBinding
import java.lang.RuntimeException

class FilterAdapter(private val click: ((Filter) -> Unit)) :
    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private var binding: ItemFilterBinding? = null
    private var dataList: List<Filter>? = null

    fun setData(data: List<Filter>) {
        this.dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.binding = ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return this.binding?.let { ViewHolder(it.root) } ?: throw RuntimeException("AA")
    }

    override fun getItemCount(): Int = dataList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dataList?.let {
            holder.bind(it[position], click)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(filter: Filter, click: ((Filter) -> Unit)) {
            binding?.filter?.text = filter.name
            binding?.filter?.setOnClickListener {
                click.invoke(filter)
            }
        }
    }
}