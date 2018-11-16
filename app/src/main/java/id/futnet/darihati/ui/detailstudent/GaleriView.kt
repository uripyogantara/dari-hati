package id.futnet.darihati.ui.detailstudent

import id.futnet.darihati.model.StudentDetail

interface GaleriView {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(galeri: MutableList<StudentDetail>)
    fun onError(t:Throwable)
}