package com.example.month6_lesson2_homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.month6_lesson2_homework.databinding.ImageItemBinding

class Adapter(
    private val list: ArrayList<Int>,
    private val clickItem: ((url: Int) -> Unit)?,
    private val deleteItem: ((url: Int) -> Unit)?
) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    inner class ViewHolder(private val binding:ImageItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(url: Int){binding.ivItem.setImageResource(url)
            itemView.setOnClickListener{
                with(binding) {
                    if (viewLayot.visibility == View.GONE) {
                        clickItem?.let {it1 -> it1(url)}
                        viewLayot.visibility = View.VISIBLE
                    } else {
                        deleteItem?.let {it1 -> it1(url)}
                        viewLayot.visibility = View.GONE
                    }
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
    override fun getItemCount(): Int = list.size
}