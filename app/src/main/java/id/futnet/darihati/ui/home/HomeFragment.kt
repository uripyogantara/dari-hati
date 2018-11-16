package id.futnet.darihati.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Community
import kotlinx.android.synthetic.main.fragment_home.*
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.model.Funding
import id.futnet.darihati.ui.community.CommunityActivity
import id.futnet.darihati.ui.funding.FundingActivity
import id.futnet.darihati.ui.student.StudentActivity
import id.futnet.darihati.utils.gone
import id.futnet.darihati.utils.visible
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class HomeFragment : Fragment(), HomeView, View.OnClickListener {


    private lateinit var communities:MutableList<Community>
    private lateinit var fundings:MutableList<Funding>

    private lateinit var service: ApiService
    private lateinit var presenter: HomePresenter
    private lateinit var compositeDisposable: CompositeDisposable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        rv_funding.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_komunitas.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        service=ApiClient.create(ctx)
        presenter=HomePresenter(service,this)
        val communityDisposable=presenter.community()
        val fundingDisposable=presenter.funding()

        compositeDisposable=CompositeDisposable()

        compositeDisposable.add(communityDisposable)
        compositeDisposable.add(fundingDisposable)
        menu_student.setOnClickListener(this)
        menu_community.setOnClickListener(this)
        menu_funding.setOnClickListener(this)
    }

    private fun setCommunityAdapater(){
        val adapter=CommunityAdapter(context,communities){
//            startActivity<DetailActivity>()
        }
        rv_komunitas.adapter=adapter
    }
    private fun setFundingAdapater(){
        val adapter=FundingAdapter(context,fundings ){
//            startActivity<DetailActivity>()
        }
        rv_funding.adapter=adapter
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.menu_student->{
                startActivity<StudentActivity>()
            }
            R.id.menu_community->{
                startActivity<CommunityActivity>()
            }
            R.id.menu_funding->{
                startActivity<FundingActivity>()
            }
            R.id.menu_payment->{

            }
        }
    }

    override fun showLoading() {
//        toast("loading")
        progres_community.visible()
    }

    override fun hideLoading() {
        progres_community.gone()
    }

    override fun onSuccess(communities: MutableList<Community>) {
        this.communities=communities
        setCommunityAdapater()
    }

    override fun onError(t: Throwable) {
        toast("Error "+t)
    }

    override fun showLoadingFunding() {
        progres_funding.visible()
    }

    override fun hideLoadingFunding() {
        progres_funding.gone()
    }

    override fun onSuccessFunding(fundings: MutableList<Funding>) {
        this.fundings=fundings
        setFundingAdapater()
        toast("sukses funding")
    }

    override fun onErrorFunding(t: Throwable) {
        toast("Error "+t)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}