package com.example.myozinsheexample.presentation.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myozinsheexample.data.OnboardingModel
import com.example.myozinsheexample.databinding.ItemViewpageOnboardingBinding

class OnboardingAdapter : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val onboardingModelList = mutableListOf<OnboardingModel>()

    fun submitList(list: List<OnboardingModel>) {
        onboardingModelList.clear()
        onboardingModelList.addAll(list)
        notifyDataSetChanged()
    }

    inner class OnboardingViewHolder(private val binding: ItemViewpageOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onboardingModel: OnboardingModel) {
            binding.tvTitleOnbarding.text = onboardingModel.title
            binding.tvDiscriptionOnbarding.text = onboardingModel.descriptor
            binding.imgTyOndoarding.setImageResource(onboardingModel.imageRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewpageOnboardingBinding.inflate(inflater, parent, false)
        return OnboardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(onboardingModelList[position])
    }

    override fun getItemCount(): Int = onboardingModelList.size
}


