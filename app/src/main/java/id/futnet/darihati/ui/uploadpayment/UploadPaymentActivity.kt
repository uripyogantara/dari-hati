package id.futnet.darihati.ui.uploadpayment

import android.R.attr
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.model.Payment
import id.futnet.darihati.utils.gone
import id.futnet.darihati.utils.visible
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_upload_payment.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.io.FileNotFoundException
import java.io.InputStream


class UploadPaymentActivity : AppCompatActivity() {
    private val RESULT_LOAD_IMG=99
    private lateinit var dialog: ProgressDialog

    private lateinit var payment: Payment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_payment)
        val service= ApiClient.create(this)

        val fundingId:Int =intent.getIntExtra("fundingId",1)
        dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Register")
        dialog.show()
        service.paymentByFunding(fundingId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({payments->
                    payment=payments[0]
                    dialog.hide()
                },{
                    dialog.hide()
                    toast("Error: "+it)
                })


        ll_camera.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG)
        }

        btn_upload_payment.setOnClickListener {
            dialog = indeterminateProgressDialog(message = "Please wait a bit…", title = "Register")
            dialog.show()
            service.pay(payment.id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({payments->
                        dialog.hide()
                        Toast.makeText(this,"Bukti Berhasil diupload",Toast.LENGTH_LONG).show()
                        finish()
                    },{
                        dialog.hide()
                        toast("Error: "+it)
                    })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode==RESULT_LOAD_IMG) {
            try {
                val imageUri: Uri? = data?.data
                val imageStream: InputStream = contentResolver.openInputStream(imageUri)
                val selectedImage = BitmapFactory.decodeStream(imageStream)
                img_payment.visible()
                img_payment.setImageBitmap(selectedImage)
                ll_camera.gone()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show()
        }
    }
}
