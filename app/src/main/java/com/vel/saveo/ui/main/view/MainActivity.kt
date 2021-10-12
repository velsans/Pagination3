package com.vel.saveo.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vel.saveo.R
import com.vel.saveo.ui.main.utils.RecyclerViewAdapter
import com.vel.saveo.ui.main.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.flow.collectLatest


class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
    }

}