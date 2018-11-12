package id.futnet.darihati.student

import id.futnet.darihati.model.Student

interface StudentView{
    fun showLoading()
    fun hideLoading()
    fun onSuccess(students: List<Student>)
    fun onError(t:Throwable)
}