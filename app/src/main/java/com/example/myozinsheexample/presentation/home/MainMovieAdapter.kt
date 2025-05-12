package com.example.myozinsheexample.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myozinsheexample.data.model.MainMoviesResponseItem
import com.example.myozinsheexample.databinding.ItemMainMoviesBinding

class MainMovieAdapter: RecyclerView.Adapter<MainMovieAdapter.MainMovieHolder>() {
    private val diffCallback = object : DiffUtil.ItemCallback<MainMoviesResponseItem> {
        override fun areItemsTheSame(
            oldItem: MainMoviesResponseItem,
            newItem: MainMoviesResponseItem,
        ): Boolean {
        return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: MainMoviesResponseItem,
            newItem: MainMoviesResponseItem,
        ): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)
    fun submitList(listMoviesMain:List<MainMoviesResponseItem>){
        differ.submitList(listMoviesMain)
    }
    private var listenerClickAtItem : RcViewItemClickMainMoviesCallback? = null

    fun setOnMovieClickListener(listener:RcViewItemClickMainMoviesCallback){
        this.listenerClickAtItem = listener
    }

    inner class MainMovieHolder(private var binding: ItemMainMoviesBinding):RecyclerView.ViewHolder(binding.root){
        fun bindItem(mainMoviesItem:MainMoviesResponseItem){
            Glide.with(itemView.context)
                .load(mainMoviesItem.link)
                .into(binding.imgMainMovie)

            binding.tvTextTitel.text = mainMoviesItem.movie.name
            binding.tvTextDescription.text = mainMoviesItem.movie.description
            itemView.setOnClickListener{
                listenerClickAtItem?.onClick(mainMoviesItem.id)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMovieHolder {
        return MainMovieHolder(
            ItemMainMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MainMovieHolder, position: Int) {
        holder.bindItem(differ.currentList.[position])
    }

}