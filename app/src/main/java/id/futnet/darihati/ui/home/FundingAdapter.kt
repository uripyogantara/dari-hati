package id.futnet.darihati.ui.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.futnet.darihati.R
import id.futnet.darihati.model.Funding
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_funding.view.*

class FundingAdapter(val context:Context?, val fundings:List<Funding>, val clickListener: (Funding) -> Unit) : RecyclerView.Adapter<FundingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_funding,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fundings.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fundings.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
        fun bind(funding: Funding,listener: (Funding) -> Unit){
            containerView.tv_student_name.text=funding.studentName
            containerView.tv_funding_title.text=funding.title
            val count="${funding.maxMember} Orang"
            containerView.tv_count_join.text=count

            Glide.with(containerView.context).load("https://darihati.futnet.id/adikasuh/${funding.studentFoto}").into(containerView.img_funding)
            Log.d("img com","https://darihati.futnet.id/funding/${funding.studentFoto}")
            itemView.setOnClickListener({
                listener(funding)
            })
        }
    }
}