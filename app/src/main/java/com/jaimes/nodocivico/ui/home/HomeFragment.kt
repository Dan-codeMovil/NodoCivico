package com.jaimes.nodocivico.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.jaimes.nodocivico.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnCreateReport =
            view.findViewById<Button>(R.id.btnCreateReport)

        val btnViewReports =
            view.findViewById<MaterialButton>(R.id.btnViewReports)

        val btnSync =
            view.findViewById<MaterialButton>(R.id.btnSync)

        val btnReminder =
            view.findViewById<MaterialButton>(R.id.btnReminder)

        val btnProfile =
            view.findViewById<MaterialButton>(R.id.btnProfile)

        val btnSettings =
            view.findViewById<MaterialButton>(R.id.btnSettings)

        btnCreateReport.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_reportCreateFragment
            )
        }

        btnViewReports.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_reportListFragment
            )
        }

        btnSync.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_syncStatusFragment
            )
        }

        btnReminder.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_reminderFragment
            )
        }

        btnProfile.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_profileFragment
            )
        }

        btnSettings.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_settingsFragment
            )
        }

    }
}