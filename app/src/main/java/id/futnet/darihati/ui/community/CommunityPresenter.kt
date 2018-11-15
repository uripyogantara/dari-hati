package id.futnet.darihati.ui.community

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CommunityPresenter(private val service: ApiService,private val view: CommunityView) {
    fun getCommunity():Disposable{
        view.showLoading()
        return service.allCommunity()
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