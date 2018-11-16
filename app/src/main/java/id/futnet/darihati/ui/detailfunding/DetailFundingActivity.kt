package id.futnet.darihati.ui.detailfunding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Funding
import id.futnet.darihati.model.Member
import kotlinx.android.synthetic.main.activity_detail_funding.*
import org.jetbrains.anko.toast

class DetailFundingActivity : AppCompatActivity(), DetailFundingView {
    private lateinit var members:MutableList<Member>
    private lateinit var adapter: DetailFundingAdapter
    private lateinit var funding: Funding
    private lateinit var service: ApiService
    private lateinit var presenter: DetailFundingPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_funding)

        funding=intent.getParcelableExtra("funding")
        service=ApiClient.create(this)

        tv_funding_title.text=funding.title
        tv_funding_description.text=funding.deskripsi

        members= mutableListOf()

        rv_funding_member.layoutManager=GridLayoutManager(this,5,GridLayoutManager.VERTICAL,false)

        presenter= DetailFundingPresenter(service,this)
        presenter.getDetailFunding(funding.id)
    }

    private fun setAdapter(){
        adapter=DetailFundingAdapter(this,members){

        }

        rv_funding_member.adapter=adapter
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onSuccess(members: MutableList<Member>) {
        this.members=members
        setAdapter()
    }

    override fun onError(t: Throwable) {
        toast("Error : "+t)
    }
}
