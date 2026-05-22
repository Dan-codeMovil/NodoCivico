package com.jaimes.nodocivico.ui.report

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaimes.nodocivico.R

class ReportDetailFragment : Fragment(R.layout.fragment_report_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnEdit.setOnClickListener {
            findNavController().navigate(
                R.id.action_reportDetailFragment_to_reportEditFragment
            )
        }

    }
}