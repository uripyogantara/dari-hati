package id.futnet.darihati.ui.detailstudent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import id.futnet.darihati.R
import id.futnet.darihati.model.Galeri
import kotlinx.android.synthetic.main.activity_detail_student.*

class DetailStudentActivity : AppCompatActivity() {
    private lateinit var galeri:MutableList<Galeri>
    private lateinit var adapter: GaleriAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_student)
        galeri= mutableListOf()
        adapter=GaleriAdapter(this,galeri){

        }
        rv_galeri.layoutManager=GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
        rv_galeri.adapter=adapter
    }
}
