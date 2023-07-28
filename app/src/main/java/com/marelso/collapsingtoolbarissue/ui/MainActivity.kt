package com.marelso.collapsingtoolbarissue.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marelso.collapsingtoolbarissue.R
import com.marelso.collapsingtoolbarissue.data.Content
import com.marelso.collapsingtoolbarissue.data.Filter

class MainActivity : AppCompatActivity() {

    private var contents: RecyclerView? = null
    private var filters: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.contents = findViewById(R.id.contents)
        this.filters = findViewById(R.id.filters)

        setupViews()
    }

    private fun setupViews() {
        val filters = mockFilters()

        this.filters?.apply {
            this.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            this.adapter = FilterAdapter(filters)
        }

        this.contents?.apply {
            this.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            this.adapter = ContentAdapter()
        }
    }

    private fun mockFilters(): List<Filter> {
        return listOf(
            Filter("DSASFASDFSA", mockContent(2)),
            Filter("ASDASDASD", mockContent(7)),
            Filter("FASADSADASD", mockContent(10)),
            Filter("DASDASD", mockContent(20)),
            Filter("ASFASFDASFD", mockContent(15)),
            Filter("FSAFADSFQWED", mockContent(12)),
            Filter("ADASFASFAS", mockContent(32)),
            Filter("FAFASDFASDF", mockContent(5)),
            Filter("afsFDASDFFASF", mockContent(9)),
            Filter("ASDFASGAFSAS", mockContent(10)),
            Filter("FSADFADFASFAS", mockContent(13)),
            Filter("DFGAFADSFASD", mockContent(21)),
            Filter("ASFFASFASDFA", mockContent(23)),
            Filter("ASFADSASFASF", mockContent(12)),
            Filter("FADFADFDAF", mockContent(8)),
            Filter("FADFADGFAGFA", mockContent(3)),
            Filter("FSAFGASFASFASF", mockContent(10)),
        )
    }

    private fun mockContent(listSize: Int): List<Content> {
        return mutableListOf<Content>().apply {
            for (i in 1..listSize) {
                this.add(Content("#$i : Test name"))
            }
        }
    }
}