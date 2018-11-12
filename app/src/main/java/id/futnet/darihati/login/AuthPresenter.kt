package id.futnet.darihati.login

import id.futnet.darihati.api.ApiService
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class AuthPresenter(private val service: ApiService,private val view: AuthView){
    fun login(email:String,password:String){
        view.showLoading()
        service.login(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { data->
                        view.onSuccess(data)
                        view.hideLoading()
                    },
                    { error->
                        view.onError(error)
                        view.hideLoading()
                    }
                )
    }
}