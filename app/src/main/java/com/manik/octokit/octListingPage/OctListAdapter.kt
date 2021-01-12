package com.manik.octokit.octListingPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manik.octokit.R
import com.manik.octokit.octListingPage.response.OctResponse

class OctListAdapter(val list: List<OctResponse>) :
    RecyclerView.Adapter<OctListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(octResponse: OctResponse) {
            val name = itemView.findViewById<TextView>(R.id.name)
            val openIssuesCount = itemView.findViewById<TextView>(R.id.openIssuesCount)
            val license = itemView.findViewById<TextView>(R.id.license)
            val permissions = itemView.findViewById<TextView>(R.id.permissions)
            val description = itemView.findViewById<TextView>(R.id.description)

            octResponse?.name?.let { name.text = it }
            octResponse?.openIssuesCount?.let { openIssuesCount.text = it.toString() }
            octResponse?.license?.let { license.text = it.name }
            octResponse?.permissions?.let { permissions.text = it.admin.toString() }
            octResponse?.description?.let { description.text = it }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_octokit, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}