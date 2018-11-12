package id.futnet.darihati.event

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import kotlinx.android.synthetic.main.fragment_event.*

class EventFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event,container,false);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_event.layoutManager= LinearLayoutManager(context)

        val adapter=EventAdapter(context){

        }
        rv_event.adapter=adapter
    }
}