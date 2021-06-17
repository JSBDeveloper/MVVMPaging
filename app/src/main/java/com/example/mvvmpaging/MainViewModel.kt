package com.example.mvvmpaging

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val noticeRepository = NoticeRepository()
    private val notice: LiveData<Data>
        get() = noticeRepository._notice

    fun loadNoticeData(page: Int) {
        noticeRepository.loadNoticeData(page)
    }

    fun getAll(): LiveData<Data> {
        return notice
    }
}