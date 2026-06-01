package com.jaimes.nodocivico.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(
            context,
            "Recordatorio activado",
            Toast.LENGTH_SHORT
        ).show()

    }
}
