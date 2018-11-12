package id.futnet.darihati.event

import id.futnet.darihati.api.ApiService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class EventPresenter(private val service: ApiService,private val view: EventView) {
    fun getEvent(){
        view.showLoading()
        service.allEvent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { events->
                        view.hideLoading()
                        view.onSuccess(events)
                    },
                    { error->
                        view.hideLoading()
                        view.onError(error)
                    }
                )
    }
}