package id.futnet.darihati.ui.community

import id.futnet.darihati.model.Community

interface CommunityView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(communities: MutableList<Community>)
    fun onError(t:Throwable)
}