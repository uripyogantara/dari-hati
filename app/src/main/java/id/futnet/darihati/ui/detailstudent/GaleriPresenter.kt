package id.futnet.darihati.ui.detailstudent

import id.futnet.darihati.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class GaleriPresenter(val service: ApiService, val view: GaleriView) {
    fun getGaleri(id:Int?):Disposable{
        view.showLoading()
        return service.studentDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.onSuccess(it)
                    view.hideLoading()
                },{
                    view.hideLoading()
                    view.onError(it)
                })
    }
}