package com.example.applicacionestudio.appjsonconsumer

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.applicacionestudio.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected:(String) -> Unit) {
        binding.tvSuperHero.text = superHeroItemResponse.name
        Picasso.get().load(superHeroItemResponse.superHeroImage.url).into(binding.ivSuperHero)
        binding.root.setOnClickListener { onItemSelected(superHeroItemResponse.superHeoId) }
    }
}