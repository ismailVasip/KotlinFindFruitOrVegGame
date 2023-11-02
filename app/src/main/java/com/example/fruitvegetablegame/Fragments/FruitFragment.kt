package com.example.fruitvegetablegame.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitvegetablegame.Adapters.AdapterFruit
import com.example.fruitvegetablegame.Singleton.MySingleton
import com.example.fruitvegetablegame.databinding.FragmentFruitBinding


class FruitFragment : Fragment() {
    private lateinit var binding: FragmentFruitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFruitBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterFruit(MySingleton.getListFruit())
        binding.recyclerViewFruit.adapter = adapter
        binding.recyclerViewFruit.layoutManager = LinearLayoutManager(this@FruitFragment.context)
    }


}