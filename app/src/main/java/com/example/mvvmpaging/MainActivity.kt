package com.example.mvvmpaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpaging.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainViewModel
    private lateinit var noticeAdapter: NoticeAdapter
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model = ViewModelProvider(this).get(MainViewModel::class.java)

        model.loadNoticeData(page)

        binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            noticeAdapter = NoticeAdapter()
            adapter = noticeAdapter
        }

        model.getAll().observe(this, Observer {
            noticeAdapter.setList(it.content)
//            noticeAdapter.notifyItemRangeChanged((page - 1) * 10, 10)
        })

        binding.mainRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition =
                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter!!.itemCount-1

                if (!binding.mainRecyclerView.canScrollVertically(1) && lastVisibleItemPosition == itemTotalCount) {
//                    noticeAdapter.deleteLoading()
                    model.loadNoticeData(++page)
                }
            }
        })
    }
}