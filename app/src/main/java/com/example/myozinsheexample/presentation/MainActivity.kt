package com.example.myozinsheexample.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.transition.Visibility
import com.example.myozinsheexample.NavigationHostProvider
import com.example.myozinsheexample.R
import com.example.myozinsheexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationHostProvider {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottonNavBar.itemIconTintList = null
        binding.bottonNavBar.setupWithNavController(navController)

    }

    override fun setNavigationVisibility(visibility: Boolean) {
        binding.bottonNavBar.visibility = if (visibility) View.VISIBLE else View.GONE
    }
}



