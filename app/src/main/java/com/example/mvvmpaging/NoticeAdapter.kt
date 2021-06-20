package com.example.mvvmpaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpaging.databinding.LayoutNoticeItemBinding

class NoticeAdapter(): RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {
    private val items = ArrayList<Content>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(
            LayoutNoticeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(notice: MutableList<Content>) {
        items.addAll(notice)
//        notice.apply {
//            val diffCallback = NoticeDiffUtilCallback(items, notice)
//            val diffResult = DiffUtil.calculateDiff(diffCallback)
//
//            items.run {
//                addAll(notice)
//                diffResult.dispatchUpdatesTo(this@NoticeAdapter)
//            }
//        }

    }

    inner class NoticeViewHolder(private val binding: LayoutNoticeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(notice: Content) {
                binding.title.text = notice.title
            }
        }
}