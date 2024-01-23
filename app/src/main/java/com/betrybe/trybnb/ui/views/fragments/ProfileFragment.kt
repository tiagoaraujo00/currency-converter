package com.betrybe.trybnb.ui.views.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.repository.TokenRepository
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ProfileFragment : Fragment() {

    private lateinit var loginLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout
    private lateinit var successMsg: TextView
    private val tokenRepository = TokenRepository()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        loginLayout = view.findViewById(R.id.login_input_profile)
        passwordLayout = view.findViewById(R.id.password_input_profile)
        successMsg = view.findViewById(R.id.success_login)
        val submitButton: Button = view.findViewById(R.id.login_button_profile)
        submitButton.setOnClickListener {
            val loginText = loginLayout.editText?.text.toString()
            val passwordText = passwordLayout.editText?.text.toString()
            inputsValidate()
            tryLogin(loginText, passwordText)
        }
        return view
    }

    private fun inputsValidate() {
        val login = loginLayout.editText?.text.toString()
        val password = passwordLayout.editText?.text.toString()
        loginLayout.error = if (login.isEmpty()) "O campo Login é obrigatório" else null
        passwordLayout.error = if (password.isEmpty()) "O campo Password é obrigatório" else null
    }

    private fun tryLogin(email: String, password: String) {
        CoroutineScope(Main).launch {
            try {
                ApiIdlingResource.increment()
                val tokenData = tokenRepository.getToken(email, password)
                val token = tokenData?.token.toString()
                if (token.isNotEmpty()) {
                    successMsg.visibility = View.VISIBLE
                } else {
                    Toast.makeText(context, "Algum erro aconteceu", Toast.LENGTH_LONG)
                        .show()
                }
                ApiIdlingResource.decrement()
            } catch (e: HttpException) {
                ApiIdlingResource.decrement()
                e.message()
            }
        }
    }
}
