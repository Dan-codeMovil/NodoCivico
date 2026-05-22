package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jaimes.nodocivico.R

class ReportListFragment : Fragment(R.layout.fragment_report_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOpenDetail =
            view.findViewById<Button>(R.id.btnOpenDetail)

        btnOpenDetail.setOnClickListener {
            findNavController().navigate(
                R.id.action_reportListFragment_to_reportDetailFragment
            )
        }
    }
}