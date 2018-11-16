package id.futnet.darihati.ui.funding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Funding
import id.futnet.darihati.ui.detailfunding.DetailFundingActivity
import id.futnet.darihati.utils.invisible
import id.futnet.darihati.utils.visible
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_funding.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class FundingActivity : AppCompatActivity(), FundingView {
    private lateinit var fundings: MutableList<Funding>
    private lateinit var adapter: FundingAdapter
    private lateinit var service: ApiService
    private lateinit var presenter: FundingPresenter
    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funding)
        setSupportActionBar(toolbar)

        setTitle("Funding")

        fundings= mutableListOf()
        rv_funding.layoutManager=LinearLayoutManager(this)

        service=ApiClient.create(this)
    }

    override fun onResume() {
        super.onResume()

        presenter= FundingPresenter(service,this)

        compositeDisposable= CompositeDisposable()

        val disposable=presenter.getFunding()
        compositeDisposable.add(disposable)
    }

    private fun setAdapter(){
        adapter=FundingAdapter(this,fundings){
            startActivity<DetailFundingActivity>("funding" to it)
        }
        rv_funding.adapter=adapter
    }

    override fun showLoadingFunding() {
        progres_funding.visible()
    }

    override fun hideLoadingFunding() {
        progres_funding.invisible()
    }

    override fun onSuccessFunding(fundings: MutableList<Funding>) {
        this.fundings=fundings
        setAdapter()
    }

    override fun onErrorFunding(t: Throwable) {
        toast("Error "+t)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
