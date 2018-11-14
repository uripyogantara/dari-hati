package id.futnet.darihati.ui.login

import id.futnet.darihati.model.User

interface AuthView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(user:User)
    fun onError(t:Throwable)
}