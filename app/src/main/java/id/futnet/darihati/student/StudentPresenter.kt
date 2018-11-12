package id.futnet.darihati.student

import id.futnet.darihati.api.ApiService
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class StudentPresenter(private val service: ApiService,private val view: StudentView) {
    fun allStudent(){
        view.showLoading()
        service.allStudent()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ students->
                    view.hideLoading()
                    view.onSuccess(students)
                },{ error->
                    view.hideLoading()
                    view.onError(error)
                })
    }
}