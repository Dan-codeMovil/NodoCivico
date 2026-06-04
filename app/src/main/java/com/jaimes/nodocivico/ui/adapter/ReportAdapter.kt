package com.jaimes.nodocivico.ui.report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jaimes.nodocivico.R
import com.jaimes.nodocivico.data.local.ReportEntity

class ReportAdapter(
    private val reports: List<ReportEntity>
) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    class ReportViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val txtTitle: TextView =
            view.findViewById(R.id.txtTitle)

        val txtCategory: TextView =
            view.findViewById(R.id.txtCategory)

        val txtlocation: TextView =
            view.findViewById(R.id.txtLocation)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReportViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_report, parent, false)

        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ReportViewHolder,
        position: Int
    ) {

        val report = reports[position]

        holder.txtTitle.text = report.title
        holder.txtCategory.text = report.category
        holder.txtLocation.text = report.location
    }

    override fun getItemCount(): Int {
        return reports.size
    }
}
