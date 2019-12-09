package br.com.gabriellferreira.baseclean.presentation.view.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.gabriellferreira.baseclean.R
import br.com.gabriellferreira.baseclean.domain.model.News
import br.com.gabriellferreira.baseclean.presentation.util.extension.inflate
import br.com.gabriellferreira.baseclean.presentation.util.extension.loadCenterCrop
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_news_cell.view.*

@Suppress("unused")
class NewsAdapter(private var data: MutableList<News> = mutableListOf())
    : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    val onItemClickSubject: PublishSubject<News> = PublishSubject.create<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.item_news_cell))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        internal fun bind(model: News, position: Int) {
            view.setOnClickListener { onItemClickSubject.onNext(model) }
            view.item_news_thumbnail?.loadCenterCrop(model.thumbnailUrl)
            view.item_news_title?.text = model.title
            view.item_news_abstract?.text = model.abstract
            view.item_news_ranking?.text = "#${position+1}"
        }
    }

    fun add(item: News) {
        this.data.add(item)
        notifyItemInserted(data.indexOf(item))
    }

    fun clear() {
        this.data.clear()
        notifyDataSetChanged()
    }
}