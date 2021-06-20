package com.example.mvvmpaging

import androidx.recyclerview.widget.DiffUtil

class NoticeDiffUtilCallback(
    private val oldNotice: List<Content>,
    private val newNotice: List<Content>
) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldNotice.size
    }

    override fun getNewListSize(): Int {
        return newNotice.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNotice[oldItemPosition] == newNotice[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNotice[oldItemPosition].created == newNotice[newItemPosition].created
    }
}