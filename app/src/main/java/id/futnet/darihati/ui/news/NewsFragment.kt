package id.futnet.darihati.ui.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.model.News
import kotlinx.android.synthetic.main.fragment_news.*
import org.jetbrains.anko.support.v4.ctx
import id.futnet.darihati.ui.news.NewsPresenter
import id.futnet.darihati.utils.gone
import id.futnet.darihati.utils.visible
import org.jetbrains.anko.support.v4.toast

class NewsFragment: Fragment(), NewsView {
    private lateinit var news: MutableList<News>
    private lateinit var service: ApiService
    private lateinit var presenter: NewsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_news.layoutManager=LinearLayoutManager(context)

        service=ApiClient.create(ctx)
        presenter=NewsPresenter(service,this)
        presenter.getNews()
    }

    private fun setAdapter(){
        val adapter=NewsAdapter(context,news)
        rv_news.adapter=adapter
    }

    override fun showLoading() {
        progres_news.visible()
    }

    override fun hideLoading() {
        progres_news.gone()
    }

    override fun onSuccess(news: MutableList<News>) {
        this.news=news
        setAdapter()
    }

    override fun onError(t: Throwable) {
        toast("Error: "+t)
    }
}