package id.futnet.darihati.student

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.futnet.darihati.R
import id.futnet.darihati.model.Student
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_adik_asuh.*
import kotlinx.android.synthetic.main.list_adik_asuh.view.*

class StudentAdapter(val context:Context?,val students:List<Student>, val clickListener: () -> Unit) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_adik_asuh,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(students.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
        private val name=containerView.tv_student_name
        private val address=containerView.tv_student_address
        fun bind(student: Student,listener: () -> Unit){
            name.text=student.name
            address.text=student.alamat
            itemView.setOnClickListener({
                listener()
            })
        }
    }
}