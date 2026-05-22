package com.jaimes.nodocivico.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jaimes.nodocivico.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnReports = view.findViewById<Button>(R.id.btnReports)
        val btnSync = view.findViewById<Button>(R.id.btnSync)

        btnReports.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_reportListFragment
            )
        }

        btnSync.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_syncStatusFragment
            )
        }
    }
}