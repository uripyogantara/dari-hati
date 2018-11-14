package id.futnet.darihati.ui.home

import id.futnet.darihati.model.Student

interface StudentView{
    fun showLoading()
    fun hideLoading()
    fun onSuccess(students: MutableList<Student>)
    fun onError(t:Throwable)
}