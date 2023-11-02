package com.example.fruitvegetablegame.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitvegetablegame.Data.DataClass
import com.example.fruitvegetablegame.databinding.RowFruitBinding

class AdapterFruit(private val fruits: List<DataClass>) : RecyclerView.Adapter<AdapterFruit.ViewHolderFruit>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFruit {
        val binding = RowFruitBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderFruit(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderFruit, position: Int) {
        holder.binding.textViewFruit.text = fruits[position].Name
        holder.binding.imageIDFruit.setImageResource(fruits[position].Image)
    }

    override fun getItemCount(): Int {
       return  fruits.size
    }

    class ViewHolderFruit(val binding: RowFruitBinding): RecyclerView.ViewHolder(binding.root) {
        //
    }
}