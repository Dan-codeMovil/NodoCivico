package com.jaimes.nodocivico.ui.sync

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.jaimes.nodocivico.R
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.jaimes.nodocivico.data.remote.api.RetrofitClient


class SyncStatusFragment : Fragment(R.layout.fragment_sync_status) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvSyncStatus =
            view.findViewById<TextView>(R.id.tvSyncStatus)

        val btnSyncNow =
            view.findViewById<MaterialButton>(R.id.btnSyncNow)

        btnSyncNow.setOnClickListener {

            lifecycleScope.launch {

                try {

                    tvSyncStatus.text = "Sincronizando..."

                    val response =
                        RetrofitClient.api.getReports()

                    if (response.isSuccessful) {

                        val reports = response.body()

                        tvSyncStatus.text =
                            "Reportes obtenidos: ${reports?.size}"

                    } else {

                        tvSyncStatus.text =
                            "Error servidor"

                    }

                } catch (e: Exception) {

                    tvSyncStatus.text =
                        "Error de conexión"

                }

            }

        }

    }
}
