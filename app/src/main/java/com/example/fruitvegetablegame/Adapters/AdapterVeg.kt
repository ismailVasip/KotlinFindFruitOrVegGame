package com.example.fruitvegetablegame.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitvegetablegame.Data.DataClass
import com.example.fruitvegetablegame.databinding.RowVegBinding

class AdapterVeg(private val vegs: List<DataClass>):RecyclerView.Adapter<AdapterVeg.ViewHolderVeg>() {

    class ViewHolderVeg(val binding: RowVegBinding): RecyclerView.ViewHolder(binding.root) {
        //
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderVeg {
        val binding = RowVegBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderVeg(binding)
    }

    override fun getItemCount(): Int {
        return vegs.size
    }

    override fun onBindViewHolder(holder: ViewHolderVeg, position: Int) {
        holder.binding.textViewVeg.text = vegs[position].Name
        holder.binding.imageIDVeg.setImageResource(vegs[position].Image)
    }

}