package id.futnet.darihati.ui.event

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.futnet.darihati.R
import id.futnet.darihati.model.Event
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_event.view.*

class EventAdapter(val context:Context?, val events:List<Event>,val clickListener: () -> Unit) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_event,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(events.get(position),clickListener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bind(event: Event,listener: () -> Unit){
            containerView.tv_event_date.text=event.startEvent
            containerView.tv_event_name.text=event.name
            containerView.tv_event_student.text=event.studentName
            containerView.setOnClickListener({
                listener()
            })
        }
    }
}