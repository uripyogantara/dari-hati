package id.futnet.darihati

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.ui.selectotp.SelectOtpActivity
import id.futnet.darihati.utils.PreferencesHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var preferencesHelper: PreferencesHelper
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        val service=ApiClient.create(this)
        preferencesHelper= PreferencesHelper(this)

        btn_register.setOnClickListener {
            dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Register")
            dialog.show()
            service.register(et_nama.text.toString(),et_email.text.toString(),et_phone.text.toString(),"-","-",et_password.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({user->
                        preferencesHelper.login=true
                        preferencesHelper.token=user.token
                        preferencesHelper.name=user.name
                        preferencesHelper.phone=user.phone
                        preferencesHelper.address=user.alamat
                        preferencesHelper.identity=user.identity
                        preferencesHelper.email=user.email
                        dialog.hide()
                        startActivity<SelectOtpActivity>()
                        finish()
                    },{
                        dialog.hide()
                        toast("Error: "+it)
                    })
        }
    }
}
