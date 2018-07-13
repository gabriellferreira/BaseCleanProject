package br.com.gabrielferreira.baseclean.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.gabrielferreira.baseclean.R
import br.com.gabrielferreira.baseclean.domain.model.News
import br.com.gabrielferreira.baseclean.presentation.util.extension.inflate
import br.com.gabrielferreira.baseclean.presentation.util.extension.loadCenterCrop
import io.reactivex.subjects.PublishSubject

@Suppress("unused")
class NewsAdapter(private var data: MutableList<News> = mutableListOf())
    : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    val onItemClickSubject: PublishSubject<News> = PublishSubject.create<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.item_news_cell))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val thumbnail: ImageView = view.findViewById(R.id.news_cell_thumbnail)
        private val text: TextView = view.findViewById(R.id.news_cell_text)
        private val date: TextView = view.findViewById(R.id.news_cell_date)

        internal fun bind(model: News) {
            view.setOnClickListener { onItemClickSubject.onNext(model) }
            thumbnail.loadCenterCrop(model.mediaUrl)
            text.text = model.title
            date.text = model.publishedDate
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