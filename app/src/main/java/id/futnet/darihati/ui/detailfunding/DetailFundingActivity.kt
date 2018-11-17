package id.futnet.darihati.ui.detailfunding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.bumptech.glide.Glide
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Funding
import id.futnet.darihati.model.Member
import id.futnet.darihati.utils.gone
import id.futnet.darihati.utils.visible
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
        Glide.with(this).load("https://darihati.futnet.id/adikasuh/${funding.studentFoto}").into(img_student)

        members= mutableListOf()

        rv_funding_member.layoutManager=GridLayoutManager(this,5,GridLayoutManager.VERTICAL,false)

        presenter= DetailFundingPresenter(service,this)
        presenter.getDetailFunding(funding.id)

        if (funding.isJoin==true){
            btn_join_funding.gone()
            btn_telah_bergabung.visible()
        }else{
            btn_join_funding.visible()
            btn_telah_bergabung.gone()
        }
        btn_join_funding.setOnClickListener({ view ->
            service.joinFunding(funding.id.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ respones->
                        toast("Join Berhasil")
//                        finish()
                        btn_join_funding.gone()
                        btn_telah_bergabung.visible()
                    },{
                        toast("Error : "+it)
                    })
        })
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
