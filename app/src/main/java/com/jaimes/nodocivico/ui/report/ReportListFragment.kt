package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaimes.nodocivico.R
import com.jaimes.nodocivico.data.model.Report
import com.jaimes.nodocivico.databinding.FragmentReportListBinding
import com.jaimes.nodocivico.ui.adapter.ReportAdapter

class ReportListFragment : Fragment(R.layout.fragment_report_list) {

    private var _binding: FragmentReportListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentReportListBinding.bind(view)

        val reports = listOf(
            Report(1, "Hueco en vía", "Hueco grande", "Infraestructura", "Calle 10"),
            Report(2, "Basura", "Acumulación basura", "Aseo", "Carrera 5")
        )

        val adapter = ReportAdapter(reports)

        binding.recyclerReports.layoutManager =
            LinearLayoutManager(requireContext())

        binding.recyclerReports.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}