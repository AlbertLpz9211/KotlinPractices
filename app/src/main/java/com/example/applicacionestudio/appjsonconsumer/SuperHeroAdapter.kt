package com.example.applicacionestudio.appjsonconsumer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applicacionestudio.R

class SuperHeroAdapter(var superheroList: List<SuperHeroItemResponse> = emptyList(), private val onItemSelected:(String) -> Unit) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {
    fun updateList(superheroList: List<SuperHeroItemResponse>) {
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superheroList[position], onItemSelected)
    }

    override fun getItemCount() = superheroList.size
}