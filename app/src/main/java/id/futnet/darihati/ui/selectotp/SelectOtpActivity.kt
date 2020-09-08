package id.futnet.darihati.ui.selectotp

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.futnet.darihati.MainActivity
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.ui.inputotp.InputOtpActivity
import id.futnet.darihati.utils.PreferencesHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_select_otp.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SelectOtpActivity : AppCompatActivity() {
    private lateinit var preferencesHelper: PreferencesHelper
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_otp)


        preferencesHelper= PreferencesHelper(this)

        ll_phone_number.setOnClickListener {
            val service= ApiClient.create(this,baseUrl = "https://darihati.uripyogantara.id/api/")
            dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Register")
            dialog.show()
            service.sendOtp("sms",preferencesHelper.phone,preferencesHelper.email)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        dialog.hide()
                        startActivity<InputOtpActivity>("type" to "sms")
                        finish()
                    },{
                        dialog.hide()
                        toast("Error: "+it)
                    })
        }

        ll_email.setOnClickListener {
            val service= ApiClient.create(this,baseUrl = "https://darihati.uripyogantara.id/api/")
            dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Register")
            dialog.show()
            service.sendOtp("email",preferencesHelper.phone,preferencesHelper.email)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        startActivity<InputOtpActivity>("type" to "email")
                        finish()
                    },{
                        dialog.hide()
                        toast("Error: "+it)
                    })
        }
    }
}
