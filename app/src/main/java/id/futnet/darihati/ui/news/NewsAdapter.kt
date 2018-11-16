package id.futnet.darihati.ui.news

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.model.News
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_news.view.*

class NewsAdapter(val context:Context?,val news:List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_news,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news[position])
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bind(news: News){
            containerView.tv_news_title.text=news.title
            containerView.tv_news_description.text="${news.communityId} - ${news.createdAt}"
        }
    }
}