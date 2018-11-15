package id.futnet.darihati.ui.home

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomePresenter(private val service: ApiService, private val view: HomeView) {
    fun community(){
        view.showLoading()
        service.limitCommunity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ community->
                    view.hideLoading()
                    view.onSuccess(community)
                },{ error->
                    view.hideLoading()
                    view.onError(error)
                })
//        return disposable
    }

    fun funding():Disposable{
        view.showLoadingFunding()
        val disposable=service.limitFunding()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.hideLoading()
                    view.onSuccessFunding(it)
                },{
                    view.hideLoading()
                    view.onErrorFunding(it)
                })
        return disposable
    }
}