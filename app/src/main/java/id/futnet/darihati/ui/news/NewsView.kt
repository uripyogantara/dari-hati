package id.futnet.darihati.ui.news

import id.futnet.darihati.model.News

interface NewsView{
    fun showLoading()
    fun hideLoading()
    fun onSuccess(news: MutableList<News>)
    fun onError(t:Throwable)
}