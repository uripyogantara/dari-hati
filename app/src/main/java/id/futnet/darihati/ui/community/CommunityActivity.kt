package id.futnet.darihati.ui.community

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Community
import id.futnet.darihati.ui.detailcommunity.DetailCommunityActivity
import id.futnet.darihati.utils.invisible
import id.futnet.darihati.utils.visible
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_community.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class CommunityActivity : AppCompatActivity(), CommunityView {
    private lateinit var communities:MutableList<Community>
    private lateinit var adapter: CommunityAdapter

    private lateinit var service: ApiService
    private lateinit var presenter: CommunityPresenter
    private lateinit var compositeDisposable: CompositeDisposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)
        setSupportActionBar(toolbar)
        setTitle("Komunitas")
        communities= mutableListOf()
        rv_community.layoutManager=LinearLayoutManager(this)

        service=ApiClient.create(this)
        presenter= CommunityPresenter(service,this)


    }

    override fun onResume() {
        super.onResume()
        val disposable=presenter.getCommunity()
        compositeDisposable=CompositeDisposable()
        compositeDisposable.add(disposable)
    }

    private fun setAdapter(){
        adapter=CommunityAdapter(this,communities){
            startActivity<DetailCommunityActivity>("community" to it)
        }
        rv_community.adapter=adapter
    }

    override fun showLoading() {
        progres_community.visible()
    }

    override fun hideLoading() {
        progres_community.invisible()
    }

    override fun onSuccess(communities: MutableList<Community>) {
        this.communities=communities
        setAdapter()
    }

    override fun onError(t: Throwable) {
        toast("Error: "+t)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
