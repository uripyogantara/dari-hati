package id.futnet.darihati.ui.detailcommunity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Community
import id.futnet.darihati.model.News
import id.futnet.darihati.utils.gone
import id.futnet.darihati.utils.visible
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail_community.*
import org.jetbrains.anko.toast

class DetailCommunityActivity : AppCompatActivity(), NewsCommunityView {
    private lateinit var news: MutableList<News>
    private lateinit var adapter: NewsCommunityAdapter
    private lateinit var community: Community
    private lateinit var presenter: NewsCommunityPresenter
    private lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_community)

        community=intent.getParcelableExtra("community")

        news= mutableListOf()
        rv_news.layoutManager= GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        setDataCommunity()

        service=ApiClient.create(this)
        presenter= NewsCommunityPresenter(service,this)
        presenter.getNews(community.id)

        if (community.isJoin==true){
            btn_join_community.gone()
            btn_joined.visible()
        }else{
            btn_join_community.visible()
            btn_joined.gone()
        }

        btn_join_community.setOnClickListener{ view ->
            service.joinCommunity(community.id.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        toast(it.message.toString())
                        btn_join_community.gone()
                        btn_joined.visible()
                    },{
                        toast("Error : "+it)
                    })
        }
    }

    private fun setDataCommunity(){
        tv_community_name.text=community.name
        tv_community_address.text=community.address
        tv_community_phone.text=community.phone
        tv_community_email.text=community.email
        tv_community_description.text=community.deskripsi

        tv_c_member.text=community.cMember.toString()
        tv_c_student.text=community.cStudent.toString()
    }

    private fun setAdapter(){
        adapter=NewsCommunityAdapter(this,news){

        }
        rv_news.adapter=adapter
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onSuccess(news: MutableList<News>) {
        this.news=news
        setAdapter()
    }

    override fun onError(t: Throwable) {
        toast("Error : "+t)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }
}
