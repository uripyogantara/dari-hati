package id.futnet.darihati.student

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiService
import kotlinx.android.synthetic.main.fragment_adik_asuh.*
import id.futnet.darihati.detail.DetailActivity
import id.futnet.darihati.model.Student
import org.jetbrains.anko.support.v4.startActivity
import id.futnet.darihati.api.ApiClient
import org.jetbrains.anko.support.v4.ctx
import id.futnet.darihati.student.StudentPresenter
import org.jetbrains.anko.support.v4.toast

class StudentFragment : Fragment(), StudentView {
    private lateinit var students:List<Student>
    private lateinit var service: ApiService
    private lateinit var presenter: StudentPresenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_adik_asuh,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_adik_asuh.layoutManager=LinearLayoutManager(context)

        service= ApiClient.create(ctx)
        presenter=StudentPresenter(service,this)
        presenter.allStudent()
    }

    private fun setAdapater(){
        val adapter=StudentAdapter(context,students){
            startActivity<DetailActivity>()
        }
        rv_adik_asuh.adapter=adapter
    }

    override fun showLoading() {
        toast("loading")
    }

    override fun hideLoading() {
        toast("hide")
    }

    override fun onSuccess(students: List<Student>) {
        this.students=students
        setAdapater()
        toast("sukses")
    }

    override fun onError(t: Throwable) {
        toast("Error "+t)
    }
}