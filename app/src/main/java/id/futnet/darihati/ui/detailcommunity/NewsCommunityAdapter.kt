package id.futnet.darihati.ui.detailcommunity

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.futnet.darihati.R
import id.futnet.darihati.model.Galeri
import id.futnet.darihati.model.News
import id.futnet.darihati.model.Student
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_funding.view.*
import kotlinx.android.synthetic.main.list_galeri.*

class NewsCommunityAdapter(val context: Context?, val news:List<News>, val clickListener: () -> Unit) : RecyclerView.Adapter<NewsCommunityAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_galeri,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
        fun bind(news: News,listener: () -> Unit){
            Glide.with(containerView.context).load("https://darihati.uripyogantara.id/berita/${news.newsDetail?.get(0)?.foto}").into(img_galeri)
            Log.d("img news","https://darihati.uripyogantara.id/berita/${news.newsDetail?.get(0)?.foto}")
            itemView.setOnClickListener({
                listener()
            })
        }
    }
}