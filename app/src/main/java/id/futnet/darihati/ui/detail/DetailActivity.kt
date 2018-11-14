package id.futnet.darihati.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import id.futnet.darihati.R
import id.futnet.darihati.ui.pendamping.PendampingFragment
import id.futnet.darihati.ui.tentang.TentangFragment
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val adapter= MyPagerAdapter(supportFragmentManager)
        viewpager_team.adapter=adapter
        tab_team_detail.setupWithViewPager(viewpager_team)

        supportActionBar?.hide()
    }

    private class MyPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    TentangFragment()
                }
                else -> {
                    return PendampingFragment()
                }
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence {
            return when (position) {
                0 -> "Tentang"
                else -> {
                    return "Relawan"
                }
            }
        }
    }
}
