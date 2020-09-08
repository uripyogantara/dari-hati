package id.futnet.darihati.ui.inputotp

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.futnet.darihati.MainActivity
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_otp.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class InputOtpActivity : AppCompatActivity() {
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        val service= ApiClient.create(this,"https://darihati.uripyogantara.id/api/")

        val type:String = intent.getStringExtra("type")

        btn_verify_otp.setOnClickListener {
            dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Register")
            dialog.show()

            val otp:String= et_otp.text.toString()
            service.confirmOtp(type,otp)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({response->
                        dialog.hide()
                        if (response.code==200){
                            startActivity<MainActivity>()
                            finish()
                        }else{
                            Toast.makeText(this@InputOtpActivity,"Otp yang anda masukkan salah",Toast.LENGTH_LONG).show()
                        }
                    },{
                        dialog.hide()
                        toast("Error: "+it)
                    })
        }
    }
}
