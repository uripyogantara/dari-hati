package id.futnet.darihati.ui.detailfunding

import id.futnet.darihati.model.DetailFunding
import id.futnet.darihati.model.Member

interface DetailFundingView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(members: MutableList<Member>)
    fun onError(t:Throwable)
}