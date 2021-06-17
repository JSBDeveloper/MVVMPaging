package com.example.mvvmpaging

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeRepository {
    var _notice = MutableLiveData<Data>()

    fun loadNoticeData(page: Int) {
        val call = BaeminApi.createApi().loadNotice(page.toString())

        call.enqueue(object : Callback<Notice> {
            override fun onResponse(call: Call<Notice>, response: Response<Notice>) {
                if (response.isSuccessful) {
                    _notice.value = response.body()?.data
                }
            }

            override fun onFailure(call: Call<Notice>, t: Throwable) {

            }
        })
    }
}