package com.example.mvvmpaging

data class Notice(val data: Data)

data class Data(val content: ArrayList<Content>)

data class Content(val title: String, val created: String)