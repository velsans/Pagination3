package com.vel.saveo.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vel.saveo.R
import com.vel.saveo.ui.main.utils.RecyclerViewHorizontalAdapter
import com.vel.saveo.ui.main.utils.RecyclerViewMainAdapter
import com.vel.saveo.ui.main.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.flow.collectLatest
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(R.layout.main_activity) {
    lateinit var recyclerViewAdapter: RecyclerViewMainAdapter
    lateinit var recyclerViewHorizontalAdapter: RecyclerViewHorizontalAdapter

    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewMainAdapter()
            adapter = recyclerViewAdapter

        }

        recyclerView_horizontal.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewHorizontalAdapter = RecyclerViewHorizontalAdapter()
            adapter = recyclerViewHorizontalAdapter

        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.getListData().collectLatest {
                recyclerViewHorizontalAdapter.submitData(it)
            }
        }
    }

}