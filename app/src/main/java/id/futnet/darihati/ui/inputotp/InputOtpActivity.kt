package id.futnet.darihati.ui.inputotp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.futnet.darihati.MainActivity
import id.futnet.darihati.R
import kotlinx.android.synthetic.main.activity_otp.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class InputOtpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        btn_verify_otp.setOnClickListener {
            startActivity<MainActivity>()
        }
    }
}
