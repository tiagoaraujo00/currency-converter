package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class CreateReservationFragment : Fragment() {

    private lateinit var firstNameLayout: TextInputLayout
    private lateinit var secondNameLayout: TextInputLayout
    private lateinit var checkinLayout: TextInputLayout
    private lateinit var checkoutLayout: TextInputLayout
    private lateinit var additionalNeedsLayout: TextInputLayout
    private lateinit var totalPriceLayout: TextInputLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_reservation, container, false)

        firstNameLayout = view.findViewById(R.id.first_name_create_reservation)
        secondNameLayout = view.findViewById(R.id.last_name_create_reservation)
        checkinLayout = view.findViewById(R.id.checkin_create_reservation)
        checkoutLayout = view.findViewById(R.id.checkout_create_reservation)
        additionalNeedsLayout = view.findViewById(R.id.additional_needs_create_reservation)
        totalPriceLayout = view.findViewById(R.id.total_price_create_reservation)

        val submitButton: Button = view.findViewById(R.id.create_reservation_button)
        submitButton.setOnClickListener {
            inputsValidate()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun inputsValidate() {
        val name = firstNameLayout.editText?.text.toString()
        val lastName = secondNameLayout.editText?.text.toString()
        val checkin = checkinLayout.editText?.text.toString()
        val checkout = checkoutLayout.editText?.text.toString()
        val additionalNeeds = additionalNeedsLayout.editText?.text.toString()
        val price = totalPriceLayout.editText?.text.toString()

        firstNameLayout.error = if (name.isEmpty()) "O campo Nome é obrigatório" else null
        secondNameLayout.error = if (lastName.isEmpty()) "O campo Sobrenome é obrigatório" else null
        checkinLayout.error = if (checkin.isEmpty()) "O campo Checkin é obrigatório" else null
        checkoutLayout.error = if (checkout.isEmpty()) "O campo Checkout é obrigatório" else null
        additionalNeedsLayout.error = if (
            additionalNeeds
                .isEmpty()
            ) {
            "O campo Necessidades Adicionais é obrigatório"
        } else {
            null
        }
        totalPriceLayout.error = if (price.isEmpty()) "O campo Preço Total é obrigatório" else null
    }
}
