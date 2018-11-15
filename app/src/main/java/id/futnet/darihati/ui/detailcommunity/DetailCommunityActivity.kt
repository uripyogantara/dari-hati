package id.futnet.darihati.ui.detailcommunity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.model.News
import kotlinx.android.synthetic.main.activity_detail_community.*

class DetailCommunityActivity : AppCompatActivity() {
    private lateinit var news: MutableList<News>
    private lateinit var adapter: NewsCommunityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_community)
        news= mutableListOf()
        rv_news.layoutManager= GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        adapter=NewsCommunityAdapter(this,news){

        }
        rv_news.adapter=adapter
    }
}
