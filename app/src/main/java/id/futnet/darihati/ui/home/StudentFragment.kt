package id.futnet.darihati.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import id.futnet.darihati.R
import id.futnet.darihati.api.ApiService
import kotlinx.android.synthetic.main.fragment_home.*
import id.futnet.darihati.ui.detail.DetailActivity
import id.futnet.darihati.model.Student
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class StudentFragment : Fragment(), StudentView {
    private lateinit var students:MutableList<Student>
    private lateinit var mainGrid:GridLayout

    private lateinit var service: ApiService
    private lateinit var presenter: StudentPresenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainGrid=main_grid

        rv_adik_asuh.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_komunitas.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
//        service= ApiClient.create(ctx)
//        presenter=StudentPresenter(service,this)
//        presenter.allStudent()
        setStudentAdapater()
        setCommunityAdapater()
    }

    private fun setStudentAdapater(){
        students= mutableListOf()
        val adapter=StudentAdapter(context,students){
            startActivity<DetailActivity>()
        }
        rv_adik_asuh.adapter=adapter
    }

    private fun setCommunityAdapater(){
        students= mutableListOf()
        val adapter=CommunityAdapter(context,students){
            startActivity<DetailActivity>()
        }
        rv_komunitas.adapter=adapter
    }

    override fun showLoading() {
        toast("loading")
    }

    override fun hideLoading() {
        toast("hide")
    }

    override fun onSuccess(students: MutableList<Student>) {
        this.students=students
        setStudentAdapater()
        toast("sukses")
    }

    override fun onError(t: Throwable) {
        toast("Error "+t)
    }
}