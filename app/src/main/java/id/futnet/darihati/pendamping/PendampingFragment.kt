package id.futnet.darihati.pendamping

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import kotlinx.android.synthetic.main.fragment_home.*
import id.futnet.darihati.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_pendamping.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.support.v4.startActivity

class PendampingFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pendamping,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_pendamping.layoutManager=LinearLayoutManager(context)

        val adapter=PendampingAdapter(context){
//            val intent=nwIntent(this,DetailActivity::class.java)
//            startActivity()
//            toast
            startActivity<DetailActivity>()
//            toast("")
        }


        rv_pendamping.adapter=adapter
    }
}