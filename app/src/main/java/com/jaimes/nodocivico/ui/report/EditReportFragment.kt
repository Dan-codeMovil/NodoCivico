package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.jaimes.nodocivico.R
import com.jaimes.nodocivico.data.local.DatabaseProvider
import com.jaimes.nodocivico.data.local.ReportEntity
import kotlinx.coroutines.launch

class EditReportFragment : Fragment(R.layout.fragment_edit_report) {

    private var currentReport: ReportEntity? = null

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val etTitle =
            view.findViewById<EditText>(R.id.etTitle)

        val etDescription =
            view.findViewById<EditText>(R.id.etDescription)

        val etCategory =
            view.findViewById<EditText>(R.id.etCategory)

        val etLocation =
            view.findViewById<EditText>(R.id.etLocation)

        val btnUpdate =
            view.findViewById<Button>(R.id.btnUpdate)

        val args =
            EditReportFragmentArgs.fromBundle(requireArguments())

        val reportId = args.reportId

        lifecycleScope.launch {

            val db =
                DatabaseProvider.getDatabase(requireContext())

            currentReport =
                db.reportDao().getReportById(reportId)

            currentReport?.let { report ->

                etTitle.setText(report.title)
                etDescription.setText(report.description)
                etCategory.setText(report.category)
                etLocation.setText(report.location)

            }
        }

        btnUpdate.setOnClickListener {

            lifecycleScope.launch {

                val report = currentReport

                if (report != null) {

                    val updatedReport = report.copy(
                        title = etTitle.text.toString(),
                        description = etDescription.text.toString(),
                        category = etCategory.text.toString(),
                        location = etLocation.text.toString()
                    )

                    val db =
                        DatabaseProvider.getDatabase(requireContext())

                    db.reportDao().updateReport(updatedReport)

                    Toast.makeText(
                        requireContext(),
                        "Reporte actualizado",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }
}