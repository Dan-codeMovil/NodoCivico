package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.jaimes.nodocivico.R
import com.jaimes.nodocivico.data.local.AppDatabase
import com.jaimes.nodocivico.data.local.ReportEntity
import kotlinx.coroutines.launch

class CreateReportFragment : Fragment(R.layout.fragment_create_report) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etDescription = view.findViewById<EditText>(R.id.etDescription)
        val etCategory = view.findViewById<EditText>(R.id.etCategory)
        val etLocation = view.findViewById<EditText>(R.id.etLocation)
        val btnSave = view.findViewById<Button>(R.id.btnSaveReport)

        val db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java,
            "nodocivico_db"
        ).build()

        btnSave.setOnClickListener {

            val title = etTitle.text.toString().trim()
            val description = etDescription.text.toString().trim()
            val category = etCategory.text.toString().trim()
            val location = etLocation.text.toString().trim()

            if (title.isEmpty() ||
                description.isEmpty() ||
                category.isEmpty() ||
                location.isEmpty()
            ) {
                Toast.makeText(
                    requireContext(),
                    "Complete todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val report = ReportEntity(
                title = title,
                description = description,
                category = category,
                location = location
            )

            lifecycleScope.launch {

                db.reportDao().insertReport(report)

                Toast.makeText(
                    requireContext(),
                    "Reporte guardado correctamente",
                    Toast.LENGTH_SHORT
                ).show()

                etTitle.text.clear()
                etDescription.text.clear()
                etCategory.text.clear()
                etLocation.text.clear()
            }
        }
    }
}