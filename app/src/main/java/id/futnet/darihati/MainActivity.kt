package id.futnet.darihati

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import id.futnet.darihati.student.StudentFragment
import id.futnet.darihati.event.EventFragment
import id.futnet.darihati.news.NewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_asuh->{
                setTitle("Dari Hati")
                loadFragment(StudentFragment())
            }

            R.id.menu_news->{
                setTitle("Cerita")
                loadFragment(NewsFragment())
            }
            R.id.menu_event->{
                setTitle("Event")
                loadFragment(EventFragment())
            }

            R.id.menu_profil->{
                setTitle("Profil")
                loadFragment(ProfilFragment())
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(StudentFragment())
        bnv.enableAnimation(false);
        bnv.enableShiftingMode(false);
        bnv.enableItemShiftingMode(false);
        bnv.setOnNavigationItemSelectedListener(this)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit()
//        }
    }
}
