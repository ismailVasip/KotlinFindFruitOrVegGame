package com.example.fruitvegetablegame.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fruitvegetablegame.R
import com.example.fruitvegetablegame.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lookFruits.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_fruitFragment)
        }
        binding.lookVegetables.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_vegFragment)
        }
        binding.playGame.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_chooseModeFragment)
        }

    }


}