package id.futnet.darihati.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Community
import kotlinx.android.synthetic.main.fragment_home.*
import id.futnet.darihati.ui.detail.DetailActivity
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.model.Funding
import id.futnet.darihati.ui.community.CommunityActivity
import id.futnet.darihati.ui.funding.FundingActivity
import id.futnet.darihati.ui.student.StudentActivity
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_funding.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class HomeFragment : Fragment(), HomeView, View.OnClickListener {


    private lateinit var communities:MutableList<Community>
    private lateinit var fundings:MutableList<Funding>
    private lateinit var mainGrid:GridLayout

    private lateinit var service: ApiService
    private lateinit var presenter: HomePresenter
    private var compositeDisposable: CompositeDisposable? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainGrid=main_grid

        rv_adik_asuh.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_komunitas.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        service=ApiClient.create(ctx)
        presenter=HomePresenter(service,this)
//        compositeDisposable?.add(presenter.community())
        presenter.community()
//        compositeDisposable?.add(presenter.funding())

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
    private fun setStudentAdapater(){
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
        toast("loading")
    }

    override fun hideLoading() {
        toast("hide")
    }

    override fun onSuccess(communities: MutableList<Community>) {
        this.communities=communities
        setCommunityAdapater()
    }

    override fun onError(t: Throwable) {
        toast("Error "+t)
    }

    override fun showLoadingFunding() {

    }

    override fun hideLoadingFunding() {

    }

    override fun onSuccessFunding(fundings: MutableList<Funding>) {

    }

    override fun onErrorFunding(t: Throwable) {

    }
}