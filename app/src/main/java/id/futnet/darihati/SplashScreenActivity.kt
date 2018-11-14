package id.futnet.darihati

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import id.futnet.darihati.ui.login.LoginActivity
import id.futnet.darihati.utils.PreferencesHelper
import org.jetbrains.anko.startActivity


class SplashScreenActivity : AppCompatActivity() {
    private lateinit var preferencesHelper: PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        preferencesHelper= PreferencesHelper(this)
        Handler().postDelayed({
            if (preferencesHelper.login){
                startActivity<MainActivity>()
            }else{
                startActivity<LoginActivity>()
            }
            finish()
        },2000)
    }
}
