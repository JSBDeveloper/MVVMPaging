package com.example.mvvmpaging

import androidx.recyclerview.widget.DiffUtil

class NoticeDiffUtilCallback(private val oldTiles: List<Notice>, private val newTiles: List<Notice>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        TODO("Not yet implemented")
    }

    override fun getNewListSize(): Int {
        TODO("Not yet implemented")
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }
}