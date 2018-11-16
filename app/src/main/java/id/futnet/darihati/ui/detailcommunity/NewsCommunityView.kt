package id.futnet.darihati.ui.detailcommunity

import id.futnet.darihati.model.News

interface NewsCommunityView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(news: MutableList<News>)
    fun onError(t:Throwable)
}