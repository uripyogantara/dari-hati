package id.futnet.darihati.ui.student

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.futnet.darihati.R
import id.futnet.darihati.model.Student
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_student.view.*

class StudentAdapter(val context: Context?, val students:List<Student>, val clickListener: (Student) -> Unit) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_student,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(students.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
//        private val name=containerView.tv_student_name
//        private val address=containerView.tv_student_address
        fun bind(student: Student, listener: (Student) -> Unit){
            containerView.tv_student_name.text=student.name
            containerView.tv_student_address.text=student.alamat
            Glide.with(containerView.context).load("https://darihati.uripyogantara.id/adikasuh/${student.foto}").into(containerView.img_student)
            containerView.setOnClickListener({
                listener(student)
            })
        }
    }
}