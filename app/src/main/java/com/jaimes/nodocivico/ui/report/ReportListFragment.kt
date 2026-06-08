package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.jaimes.nodocivico.R
import com.jaimes.nodocivico.data.local.DatabaseProvider
import kotlinx.coroutines.launch

class ReportListFragment : Fragment(R.layout.fragment_report_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar =
            view.findViewById<ProgressBar>(R.id.progressBar)

        val txtEmpty =
            view.findViewById<TextView>(R.id.txtEmpty)

        val recyclerReports =
            view.findViewById<RecyclerView>(R.id.recyclerReports)

        recyclerReports.layoutManager =
            LinearLayoutManager(requireContext())

        lifecycleScope.launch {

            val db =
                DatabaseProvider.getDatabase(requireContext())

            val reports =
                db.reportDao().getAllReports()

            progressBar.visibility = View.GONE

            txtEmpty.visibility =
                if (reports.isEmpty()) View.VISIBLE
                else View.GONE

            ReportListFragmentDirections

            val adapter = ReportAdapter(reports) { report ->

                val action =
                    ReportListFragmentDirections
                        .actionReportListFragmentToReportEditFragment(
                            report.id
                        )

                findNavController().navigate(action)

            }

            recyclerReports.adapter = adapter
        }

        val btnCreate =
            view.findViewById<MaterialButton>(R.id.btnCreate)

        btnCreate.setOnClickListener {

            findNavController().navigate(
                R.id.action_reportListFragment_to_reportCreateFragment
            )

        }
    }
}