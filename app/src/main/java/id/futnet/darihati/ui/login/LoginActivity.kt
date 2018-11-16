package id.futnet.darihati.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.futnet.darihati.MainActivity
import id.futnet.darihati.R
import id.futnet.darihati.RegisterActivity
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.User
import id.futnet.darihati.utils.PreferencesHelper
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(),AuthView {
    private lateinit var presenter: AuthPresenter
    private lateinit var service: ApiService
    private lateinit var preferencesHelper: PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        service=ApiClient.create(this)
        presenter= AuthPresenter(service,this)
        preferencesHelper= PreferencesHelper(this)

        btn_login.setOnClickListener({
            presenter.login(et_email.text.toString(),et_password.text.toString())
//            startActivity<MainActivity>()
        })

        txt_register.setOnClickListener({
            startActivity<RegisterActivity>()
            finish()
        })
    }

    override fun showLoading() {
        toast("loading")
    }

    override fun hideLoading() {

    }

    override fun onSuccess(user: User) {
        preferencesHelper.login=true
        preferencesHelper.token=user.token
        preferencesHelper.name=user.name
        preferencesHelper.phone=user.phone
        preferencesHelper.address=user.alamat
        preferencesHelper.identity=user.identity
        preferencesHelper.email=user.email
        startActivity<MainActivity>()
        finish()

    }

    override fun onError(t: Throwable) {
        toast("Error: "+t)
    }
}
