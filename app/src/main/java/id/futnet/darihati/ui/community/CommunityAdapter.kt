package id.futnet.darihati.ui.community

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.model.Community
import id.futnet.darihati.model.Funding
import id.futnet.darihati.model.Student
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_community_activity.view.*
import kotlinx.android.synthetic.main.list_funding.view.*

class CommunityAdapter(val context: Context?, val communities:List<Community>, val clickListener: (Community) -> Unit) : RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_community_activity,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return communities.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(communities[position],clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer {
        fun bind(community: Community,listener: (Community) -> Unit){
            containerView.tv_community_name.text=community.name
            containerView.tv_community_description.text=community.deskripsi
            containerView.tv_community_member.text="${community.cMember} Orang Anggota"
            containerView.tv_community_student.text="${community.cStudent} Orang Adik Asuh"
            itemView.setOnClickListener({
                listener(community)
            })
        }
    }
}