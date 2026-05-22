package com.jaimes.nodocivico.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaimes.nodocivico.data.model.Report
import com.jaimes.nodocivico.databinding.ItemReportBinding

class ReportAdapter(
    private val reports: List<Report>
) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    inner class ReportViewHolder(
        private val binding: ItemReportBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(report: Report) {
            binding.tvTitle.text = report.title
            binding.tvCategory.text = report.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {

        val binding = ItemReportBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ReportViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.bind(reports[position])
    }

    override fun getItemCount(): Int = reports.size
}