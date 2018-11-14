package id.futnet.darihati.ui.community

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.model.Community
import kotlinx.android.synthetic.main.activity_community.*

class CommunityActivity : AppCompatActivity() {
    private lateinit var communities:MutableList<Community>
    private lateinit var adapter: CommunityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)
        setSupportActionBar(toolbar)
        communities= mutableListOf()

        rv_community.layoutManager=LinearLayoutManager(this)
        adapter=CommunityAdapter(this,communities){

        }
        rv_community.adapter=adapter
    }
}
