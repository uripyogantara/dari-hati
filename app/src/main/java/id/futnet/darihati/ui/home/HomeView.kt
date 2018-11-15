package id.futnet.darihati.ui.home

import id.futnet.darihati.model.Community
import id.futnet.darihati.model.Funding
import id.futnet.darihati.model.Student

interface HomeView{
    fun showLoading()
    fun hideLoading()
    fun onSuccess(communities: MutableList<Community>)
    fun onError(t:Throwable)

    fun showLoadingFunding()
    fun hideLoadingFunding()
    fun onSuccessFunding(fundings: MutableList<Funding>)
    fun onErrorFunding(t:Throwable)
}