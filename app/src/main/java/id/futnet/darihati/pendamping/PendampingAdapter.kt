package id.futnet.darihati.pendamping

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R

class PendampingAdapter(val context:Context?, val clickListener: () -> Unit) : RecyclerView.Adapter<PendampingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_pendamping,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clickListener)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(listener: () -> Unit){
            itemView.setOnClickListener({
                listener()
            })
        }
    }
}