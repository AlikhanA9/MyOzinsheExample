package com.example.myozinsheexample.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myozinsheexample.data.SharedProvider
import com.example.myozinsheexample.databinding.FragmentHomeBinding
import com.example.myozinsheexample.presentation.Login.LoginViewModel
import com.example.myozinsheexample.provideNavigationHost

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        provideNavigationHost()?.apply {
            setNavigationVisibility(false)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        provideNavigationHost()?.apply {
            setNavigationVisibility(false)
        }
        val token = SharedProvider(requireContext()).getToken()
        viewModel.getMainMoives(token)
        val adapterMainMovie = MainMovieAdapter()
        binding.rcMainMovies.adapter = MainMovieAdapter()
        viewModel.mainMoviesResponse.observe(viewLifecycleOwner){
            adapterMainMovie.submitList(it)
        }
    }
    }
