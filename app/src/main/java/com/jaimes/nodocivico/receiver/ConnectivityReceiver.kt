package com.jaimes.nodocivico.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ConnectivityReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(
            context,
            "Cambio de conectividad detectado",
            Toast.LENGTH_SHORT
        ).show()

    }
}

