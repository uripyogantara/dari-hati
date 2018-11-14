package id.futnet.darihati.ui.student

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.model.Student
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {
    private lateinit var students: MutableList<Student>
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        setSupportActionBar(toolbar)
        students= mutableListOf()

        rv_student.layoutManager= LinearLayoutManager(this)
        adapter=StudentAdapter(this,students){

        }

        rv_student.adapter=adapter
    }
}
