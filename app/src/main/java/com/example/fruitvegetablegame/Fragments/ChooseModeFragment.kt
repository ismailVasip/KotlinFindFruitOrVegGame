package com.example.fruitvegetablegame.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.fruitvegetablegame.R
import com.example.fruitvegetablegame.databinding.FragmentChooseModeBinding

class ChooseModeFragment : Fragment() {
    private lateinit var binding :FragmentChooseModeBinding
    private var checkedRButtonId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChooseModeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if(i == R.id.fruitButton)
                checkedRButtonId = 1
            else if(i == R.id.vegButton)
                checkedRButtonId = 2
        }

        binding!!.buttonStart.setOnClickListener {
            if(checkedRButtonId != 0){
                val action = ChooseModeFragmentDirections.actionChooseModeFragmentToGameFragment(checkedRButtonId)
                Navigation.findNavController(it).navigate(action)

            }
        }
    }

}