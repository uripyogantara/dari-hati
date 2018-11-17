package id.futnet.darihati.ui.detailstudent

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.futnet.darihati.R
import id.futnet.darihati.model.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_funding.view.*
import kotlinx.android.synthetic.main.list_galeri.view.*

class GaleriAdapter(val context: Context?, val galeri:List<StudentDetail>, val clickListener: () -> Unit) : RecyclerView.Adapter<GaleriAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_galeri,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return galeri.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(galeri.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
//        private val name=containerView.tv_student_name
//        private val address=containerView.tv_student_address
        fun bind(detail: StudentDetail, listener: () -> Unit){
    Glide.with(containerView.context).load("https://darihati.futnet.id/rumah/${detail.fotoRumah}").into(containerView.img_galeri)
            itemView.setOnClickListener({
                listener()
            })
        }
    }
}