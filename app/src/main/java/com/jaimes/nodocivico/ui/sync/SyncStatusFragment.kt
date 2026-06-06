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
import com.jaimes.nodocivico.data.local.DatabaseProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



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

                        if (reports != null) {

                            val db =
                                DatabaseProvider.getDatabase(requireContext())

                            val dao = db.reportDao()

                            withContext(Dispatchers.IO) {

                                reports.forEach { report ->

                                    dao.insertReport(report)

                                }

                            }

                            tvSyncStatus.text =
                                "Sincronización completada"

                        } else {

                            tvSyncStatus.text =
                                "No se recibieron datos"

                        }

                    } else {

                        tvSyncStatus.text =
                            "Servidor no disponible"

                    }

                } catch (e: Exception) {

                    tvSyncStatus.text =
                        "Servidor no disponible"

                }

            }

        }

    }
}
