package br.com.gabrielferreira.baseclean.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.presentation.model.NewsViewModel
import br.com.gabrielferreira.baseclean.presentation.util.extension.inflate

class NewsAdapter(private var data: MutableList<NewsViewModel> = mutableListOf())
    : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.item_news_cell))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        internal fun bind(model: NewsViewModel) {
//            view.comment_author.text = model.author
//            view.comment_text.text = model.comment
        }
    }

    fun add(item: NewsViewModel) {
        this.data.add(item)
        notifyItemInserted(data.indexOf(item))
    }

    fun clear() {
        this.data.clear()
        notifyDataSetChanged()
    }
}