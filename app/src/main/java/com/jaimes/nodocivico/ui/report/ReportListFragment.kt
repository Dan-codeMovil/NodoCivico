package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.jaimes.nodocivico.R

class ReportListFragment : Fragment(R.layout.fragment_report_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar =
            view.findViewById<ProgressBar>(R.id.progressBar)

        val txtEmpty =
            view.findViewById<TextView>(R.id.txtEmpty)

        progressBar.visibility = View.GONE
        txtEmpty.visibility = View.VISIBLE
        Toast.makeText(context, "Error de conexión", Toast.LENGTH_SHORT).show()

        val btnCreate = view.findViewById<MaterialButton>(R.id.btnCreate)
        val btnOpenDetail = view.findViewById<MaterialButton>(R.id.btnOpenDetail)

        // Ir a crear reporte
        btnCreate.setOnClickListener {
            findNavController().navigate(
                R.id.action_reportListFragment_to_reportCreateFragment
            )
        }

        // Ir a detalle
        btnOpenDetail.setOnClickListener {
            findNavController().navigate(
                R.id.action_reportListFragment_to_reportDetailFragment
            )
        }



    }
}