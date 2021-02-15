package com.jobapply.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jobapply.myapplication.R
import com.jobapply.myapplication.databinding.RcListCellBinding
import com.jobapply.myapplication.model.Article

class MyRecyclerViewAdapter(
    val listArticle: List<Article>,
    val clickListener: (Article) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RcListCellBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.rc_list_cell, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listArticle.get(position), clickListener)
    }

    override fun getItemCount(): Int {
        return listArticle.size
    }

}

class MyViewHolder(val binding: RcListCellBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article, clickListener: (Article) -> Unit) {
        binding.tvName.text = article.author
        binding.tvDesc.text = article.description
        binding.layoutClick.setOnClickListener {
            clickListener(article)
        }
    }
}