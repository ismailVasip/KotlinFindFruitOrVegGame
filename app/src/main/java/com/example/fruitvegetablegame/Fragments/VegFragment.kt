package com.example.fruitvegetablegame.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitvegetablegame.Adapters.AdapterVeg
import com.example.fruitvegetablegame.Singleton.MySingleton
import com.example.fruitvegetablegame.databinding.FragmentVegBinding


class VegFragment : Fragment() {
    private lateinit var binding:FragmentVegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVegBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterVeg(MySingleton.getListVeg())
        binding.recyclerViewVeg.adapter = adapter
        binding.recyclerViewVeg.layoutManager = LinearLayoutManager(this@VegFragment.context)
    }


}