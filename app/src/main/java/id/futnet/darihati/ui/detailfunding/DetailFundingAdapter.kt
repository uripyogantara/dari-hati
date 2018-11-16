package id.futnet.darihati.ui.detailfunding

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.model.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_funding.view.*

class DetailFundingAdapter(val context: Context?, val members:List<Member>, val clickListener: () -> Unit) : RecyclerView.Adapter<DetailFundingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_funding_member,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(students.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
        fun bind(listener: () -> Unit){
            itemView.setOnClickListener({
                listener()
            })
        }
    }
}