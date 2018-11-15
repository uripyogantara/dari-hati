package id.futnet.darihati.ui.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.model.Community
import id.futnet.darihati.model.Student
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_community.view.*

class CommunityAdapter(val context:Context?, val communities:List<Community>, val clickListener: () -> Unit) : RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_community,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return communities.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(communities.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
        fun bind(community: Community,listener: () -> Unit){
            containerView.tv_community_name.text=community.name

            val cMember="${community.cMember} Orang"
            containerView.tv_community_member_count.text=cMember
//            address.text=student.alamat
            itemView.setOnClickListener({
                listener()
            })
        }
    }
}