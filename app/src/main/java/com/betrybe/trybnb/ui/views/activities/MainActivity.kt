package com.betrybe.trybnb.ui.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybnb.R
import com.betrybe.trybnb.ui.views.fragments.CreateReservationFragment
import com.betrybe.trybnb.ui.views.fragments.ProfileFragment
import com.betrybe.trybnb.ui.views.fragments.ReservationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val mBottomNavigation: BottomNavigationView by lazy { findViewById(R.id.navigation_bottom_view) }
    private val profileFragment = ProfileFragment()
    private val reservationFragment = ReservationFragment()
    private val createReservationFragment = CreateReservationFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, reservationFragment)
            .commit()

        mBottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.reservation_menu_item -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, reservationFragment)
                        .commit()
                }
                R.id.create_reservation_menu_item -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, createReservationFragment)
                        .commit()
                }
                R.id.profile_menu_tem -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, profileFragment)
                        .commit()
                }
            }

            true
        }
    }
}
