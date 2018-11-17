package id.futnet.darihati.ui.detailstudent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.bumptech.glide.Glide
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Galeri
import id.futnet.darihati.model.Student
import id.futnet.darihati.model.StudentDetail
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_detail_student.*
import org.jetbrains.anko.toast

class DetailStudentActivity : AppCompatActivity(), GaleriView {
    private lateinit var galeri:MutableList<StudentDetail>
    private lateinit var adapter: GaleriAdapter
    private lateinit var student: Student

    private lateinit var service: ApiService
    private lateinit var presenter: GaleriPresenter

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)

        student=intent.getParcelableExtra("student")
        galeri= mutableListOf()
        compositeDisposable= CompositeDisposable()
        rv_galeri.layoutManager=GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)

        tv_student_name.text=student.name
        tv_student_address.text=student.alamat
        tv_community_name.text=student.communityName
        tv_student_description.text=student.deskripsi
        Glide.with(this).load("https://darihati.futnet.id/adikasuh/${student.foto}").into(img_student)

        service=ApiClient.create(this)
        presenter= GaleriPresenter(service,this)
        val disposable=presenter.getGaleri(student.id)
        compositeDisposable.add(disposable)
    }

    private fun setAdapter(){
        adapter=GaleriAdapter(this,galeri){

        }
        rv_galeri.adapter=adapter
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onSuccess(galeri: MutableList<StudentDetail>) {
        this.galeri=galeri
        setAdapter()
    }

    override fun onError(t: Throwable) {
        toast("Error : "+t)
    }
}
