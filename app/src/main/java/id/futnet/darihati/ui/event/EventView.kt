package id.futnet.darihati.ui.event

import id.futnet.darihati.model.Event


interface EventView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(events: List<Event>)
    fun onError(t:Throwable)
}