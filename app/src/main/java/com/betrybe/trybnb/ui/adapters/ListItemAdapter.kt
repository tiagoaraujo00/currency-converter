package com.betrybe.trybnb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.Bookingids

class ListItemAdapter(private val itemList: List<Bookingids>) : Adapter<ListItemAdapter
    .BookingIdViewHolder>() {

    class BookingIdViewHolder(view: View) : ViewHolder(view) {
        val nameItemReservation: TextView = view.findViewById(R.id.name_item_reservation)
        val checkinItemReservation: TextView = view.findViewById(R.id.checkin_item_reservation)
        val checkoutItemReservation: TextView = view.findViewById(R.id.checkout_item_reservation)
        val additionalNeedsItemReservation: TextView = view
            .findViewById(R.id.additional_needs_item_reservation)
        val totalPriceItemReservation: TextView = view
            .findViewById(R.id.total_price_item_reservation)
    }

    override fun getItemCount() = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingIdViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_reservation, parent, false)
        return BookingIdViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingIdViewHolder, position: Int) {
        holder.nameItemReservation.text = itemList[position]
            .firstname + " " + itemList[position].lastname
        holder.checkinItemReservation.text = itemList[position].bookingdates.checkin
        holder.checkoutItemReservation.text = itemList[position].bookingdates.checkout
        holder.additionalNeedsItemReservation.text = itemList[position].additionalneeds
        holder.totalPriceItemReservation.text = itemList[position].totalprice.toString()
    }
}
