package id.futnet.darihati.ui.student

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StudentPresenter(private val service: ApiService,private val view: StudentView) {

    fun getStudents():Disposable{
        view.showLoading()
        return service.allStudent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.hideLoading()
                    view.onSuccess(it)
                },{
                    view.hideLoading()
                    view.onError(it)
                })
    }
}