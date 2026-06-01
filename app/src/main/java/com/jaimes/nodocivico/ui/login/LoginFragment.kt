package com.jaimes.nodocivico.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.jaimes.nodocivico.R

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<MaterialButton>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_homeFragment
            )
        }
    }
}