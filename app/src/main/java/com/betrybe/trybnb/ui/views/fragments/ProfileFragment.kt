package com.betrybe.trybnb.ui.views.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class ProfileFragment : Fragment() {

    private lateinit var loginLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        loginLayout = view.findViewById(R.id.login_input_profile)
        passwordLayout = view.findViewById(R.id.password_input_profile)

        val submitButton: Button = view.findViewById(R.id.login_button_profile)
        submitButton.setOnClickListener {
            inputsValidate()
        }

        return view
    }

    private fun inputsValidate() {
        val login = loginLayout.editText?.text.toString()
        val password = passwordLayout.editText?.text.toString()

        loginLayout.error = if (login.isEmpty()) "O campo Login é obrigatório" else null
        passwordLayout.error = if (password.isEmpty()) "O campo Password é obrigatório" else null
    }
}
