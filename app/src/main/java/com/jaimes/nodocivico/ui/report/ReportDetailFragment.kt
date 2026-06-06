package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jaimes.nodocivico.R

class ReportDetailFragment :
    Fragment(R.layout.fragment_report_detail) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {

        super.onViewCreated(view, savedInstanceState)

        val btnEdit =
            view.findViewById<MaterialButton>(
                R.id.btnEditReport
            )

        btnEdit.setOnClickListener {

            findNavController().navigate(
                R.id.action_reportDetailFragment_to_reportEditFragment
            )

        }
    }
}
