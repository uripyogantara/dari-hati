package id.futnet.darihati.ui.detailcommunity

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NewsCommunityPresenter(val service: ApiService,val view: NewsCommunityView){
    val compositeDisposable=CompositeDisposable()
    fun getNews(id:Int?){
        view.showLoading()
        val disposable=service.newsCommunity(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.hideLoading()
                view.onSuccess(it)
            },{
                view.hideLoading()
                view.onError(it)
            })

        compositeDisposable.add(disposable)
    }

    fun clear(){
        compositeDisposable.clear()
    }
}