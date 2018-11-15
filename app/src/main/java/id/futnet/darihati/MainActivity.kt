package id.futnet.darihati

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import id.futnet.darihati.ui.home.StudentFragment
import id.futnet.darihati.ui.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home->{
                loadFragment(StudentFragment())
            }

            R.id.menu_news->{
                loadFragment(NewsFragment())
            }
//            R.id.menu_event->{
//                setTitle("Event")
//                loadFragment(EventFragment())
//            }

            R.id.menu_profil->{
                loadFragment(ProfilFragment())
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
        loadFragment(StudentFragment())
        bnv.enableAnimation(false)
        bnv.setLabelVisibilityMode(1)
        bnv.setItemHorizontalTranslationEnabled(false)
//        bnv.enableItemShiftingMode(false);

        bnv.setOnNavigationItemSelectedListener(this)
        bnv.setIconSize(26F, 26F)
//        bnv.setTextSize(12F)

        setActionBar()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit()
//        }
    }

    private fun setActionBar() {
        val actionBar = supportActionBar
        actionBar!!.displayOptions = actionBar.displayOptions or ActionBar.DISPLAY_SHOW_CUSTOM
        val imageView = ImageView(actionBar.themedContext)
        imageView.scaleType = ImageView.ScaleType.CENTER
        imageView.setImageResource(R.drawable.logo_name)
        val layoutParams = ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER)
        layoutParams.leftMargin = 10
        layoutParams.rightMargin = 10
        layoutParams.topMargin = 15
        layoutParams.bottomMargin = 15

        imageView.layoutParams = layoutParams
        imageView.adjustViewBounds = true
        actionBar.customView = imageView
    }
}
