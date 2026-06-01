package com.jaimes.nodocivico.ui.sync

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.jaimes.nodocivico.R

class SyncStatusFragment : Fragment(R.layout.fragment_sync_status) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSyncStatus =
            view.findViewById<TextView>(R.id.tvSyncStatus)

        val btnSyncNow =
            view.findViewById<MaterialButton>(R.id.btnSyncNow)

        btnSyncNow.setOnClickListener {

            tvSyncStatus.text = "Sincronizando..."

            Toast.makeText(
                context,
                "Sincronización iniciada",
                Toast.LENGTH_SHORT
            ).show()

            // TEMPORAL
            tvSyncStatus.text = "Datos sincronizados correctamente"

        }
    }
}
