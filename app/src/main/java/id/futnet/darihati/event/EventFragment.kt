package id.futnet.darihati.event

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiService
import kotlinx.android.synthetic.main.fragment_event.*
import id.futnet.darihati.api.ApiClient
import org.jetbrains.anko.support.v4.ctx
import id.futnet.darihati.event.EventPresenter
import id.futnet.darihati.model.Event
import org.jetbrains.anko.support.v4.toast

class EventFragment:Fragment(), EventView {
    private lateinit var service: ApiService
    private lateinit var presenter: EventPresenter
    private lateinit var events:List<Event>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event,container,false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_event.layoutManager= LinearLayoutManager(context)

        service=ApiClient.create(ctx)
        presenter=EventPresenter(service,this)
        presenter.getEvent()

    }

    override fun showLoading() {
        toast("loading")
    }

    override fun hideLoading() {

    }

    override fun onSuccess(events: List<Event>) {
        this.events=events
        setAdapater()
    }

    override fun onError(t: Throwable) {
        toast("Error : " +t)
    }

    private fun setAdapater(){
        val adapter=EventAdapter(context,events){

        }
        rv_event.adapter=adapter
    }
}