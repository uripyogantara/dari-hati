package id.futnet.darihati.ui.funding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.model.Funding
import kotlinx.android.synthetic.main.activity_funding.*

class FundingActivity : AppCompatActivity() {
    private lateinit var fundings: MutableList<Funding>
    private lateinit var adapter: FundingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funding)
        setSupportActionBar(toolbar)
        fundings= mutableListOf()

        rv_funding.layoutManager=LinearLayoutManager(this)
        adapter=FundingAdapter(this,fundings){

        }

        rv_funding.adapter=adapter
    }
}
