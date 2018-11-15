package id.futnet.darihati.ui.funding

import id.futnet.darihati.model.Funding

interface FundingView {
    fun showLoadingFunding()
    fun hideLoadingFunding()
    fun onSuccessFunding(fundings: MutableList<Funding>)
    fun onErrorFunding(t:Throwable)
}