package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.api.BookingServiceApi
import com.betrybe.trybnb.ui.adapters.ListItemAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservationFragment : Fragment() {

    private val apiService = BookingServiceApi.instance

    private lateinit var  mRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reservation, container, false)

        CoroutineScope(Dispatchers.IO).launch {
            val bookingResponse = apiService.getBooking()
             val bookingIds = bookingResponse.body()
            bookingIds?.forEach { _ ->
                Log.i("Ids", bookingIds.toString())
            }
            withContext(Dispatchers.Main) {
                //val listItemAdapter = ListItemAdapter()
                //mRecyclerView.adapter = listItemAdapter
                //listItemAdapter.notifyDataBaseChanged()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView = view.findViewById(R.id.reservation_recycler_view)
        mRecyclerView.layoutManager = LinearLayoutManager(context)

    }
}
