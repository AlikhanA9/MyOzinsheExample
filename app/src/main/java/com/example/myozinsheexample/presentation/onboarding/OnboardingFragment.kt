package com.example.myozinsheexample.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.myozinsheexample.R
import com.example.myozinsheexample.data.OnboardingInfoList
import com.example.myozinsheexample.databinding.FragmentOnboardingBinding
import com.example.myozinsheexample.provideNavigationHost

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        provideNavigationHost()?.apply {
            setNavigationVisibility(false)


            val adapter = OnboardingAdapter()
            adapter.submitList(OnboardingInfoList.onboardingModelList)
            binding.viewPager2OnboardigFragment.adapter = adapter
            binding.dotsIndiator.setViewPager2(binding.viewPager2OnboardigFragment)

            val pageCount = OnboardingInfoList.onboardingModelList.size


            binding.btuSkipOnboardingFragment.setOnClickListener {
                findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
            }


            binding.btuNextOnboardingFragment.setOnClickListener {
                val current = binding.viewPager2OnboardigFragment.currentItem
                if (current < pageCount - 1) {
                    binding.viewPager2OnboardigFragment.currentItem = current + 1
                } else {

                    findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
                }
            }


            binding.viewPager2OnboardigFragment.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        if (position == pageCount - 1) {
                            binding.btuSkipOnboardingFragment.visibility = View.INVISIBLE
                            binding.btuNextOnboardingFragment.visibility = View.VISIBLE
                        } else {
                            binding.btuSkipOnboardingFragment.visibility = View.VISIBLE
                            binding.btuNextOnboardingFragment.visibility = View.INVISIBLE
                        }
                    }
                }
            )
        }
    }
}



