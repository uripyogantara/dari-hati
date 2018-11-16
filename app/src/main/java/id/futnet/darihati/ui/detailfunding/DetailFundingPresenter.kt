package id.futnet.darihati.ui.detailfunding

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailFundingPresenter(private val service: ApiService,private val view: DetailFundingView) {
    private val compositeDisposable=CompositeDisposable()

    fun getDetailFunding(id:Int?){
        view.showLoading()

        val disposable=service.fundingMember(id)
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