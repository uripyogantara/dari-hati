package id.futnet.darihati.ui.funding

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FundingPresenter(private val service: ApiService,private val view: FundingView) {
    fun getFunding():Disposable{
        view.showLoadingFunding()
        return service.allFunding()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.hideLoadingFunding()
                    view.onSuccessFunding(it)
                },{
                    view.hideLoadingFunding()
                    view.onErrorFunding(it)
                })
    }
}