package id.futnet.darihati.ui.student

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiClient
import id.futnet.darihati.api.ApiService
import id.futnet.darihati.model.Student
import id.futnet.darihati.ui.detailstudent.DetailStudentActivity
import id.futnet.darihati.utils.gone
import id.futnet.darihati.utils.visible
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_student.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class StudentActivity : AppCompatActivity(), StudentView {
    private lateinit var students: MutableList<Student>
    private lateinit var adapter: StudentAdapter

    private lateinit var service: ApiService
    private lateinit var presenter: StudentPresenter
    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        setSupportActionBar(toolbar)
        setTitle("Adik Asuh")
        students= mutableListOf()
        rv_student.layoutManager= LinearLayoutManager(this)

        service=ApiClient.create(this)

        presenter= StudentPresenter(service,this)
        val disposable=presenter.getStudents()


        compositeDisposable= CompositeDisposable()
        compositeDisposable.add(disposable)

    }

    private fun setAdapter(){
        adapter=StudentAdapter(this,students){
            startActivity<DetailStudentActivity>("student" to it)
        }

        rv_student.adapter=adapter
    }

    override fun showLoading() {
        progres_student.visible()
    }

    override fun hideLoading() {
        progres_student.gone()
    }

    override fun onSuccess(students: MutableList<Student>) {
        this.students=students
        setAdapter()
    }

    override fun onError(t: Throwable) {
        toast("Error : "+t)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
