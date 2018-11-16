package id.futnet.darihati.ui.news

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsPresenter(private val service: ApiService,private val view: NewsView){
    private val compositeDisposable=CompositeDisposable()

    fun getNews(){
        view.showLoading()
        val disposable=service.allNews()
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