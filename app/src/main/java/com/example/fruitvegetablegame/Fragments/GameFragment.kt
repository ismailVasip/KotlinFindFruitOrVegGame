package com.example.fruitvegetablegame.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.example.fruitvegetablegame.Data.DataClass
import com.example.fruitvegetablegame.R
import com.example.fruitvegetablegame.Singleton.MySingleton
import com.example.fruitvegetablegame.databinding.FragmentGameBinding
import java.util.Random

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var runnable : Runnable
    private var handler : Handler = Handler(Looper.getMainLooper())
    private lateinit var listAllData :List<DataClass>
    private lateinit var shuffledListAllData :List<DataClass>
    private var maxScore : Int = 0
    private var myScore : Int = 0
    private var randomIndex : Int = 0
    val random = Random()
    private var getMode : Int = 0
    private var isClickable = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            getMode = GameFragmentArgs.fromBundle(it).mode
        }

        listAllData = MySingleton.getListFruit() + MySingleton.getListVeg()

        shuffledListAllData = listAllData.shuffled()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeImage()

        object : CountDownTimer(10900,500){
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Left: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.timeText.text = "Time's up!"

                handler.removeCallbacks(runnable)

                binding.imageView.isClickable = false

                // alert
                val alert = AlertDialog.Builder(requireContext())

                alert.setTitle("Game Over")
                alert.setMessage("Max Score = ${maxScore}\nYour Score = ${myScore}\nRestart The Game?")

                alert.setPositiveButton("Yes") {dialog, which ->
                   Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_chooseModeFragment)
                }

                alert.setNegativeButton("No") {dialog, which ->
                    Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_mainFragment)
                }

                alert.show()
            }

        }.start()

    }

    fun changeImage(){
        runnable = object : Runnable {
            override fun run() {

                randomIndex = random.nextInt(shuffledListAllData.size)

                if(getMode == 1 && MySingleton.getListFruit().contains(shuffledListAllData[randomIndex])){
                    // fruit
                    maxScore++

                } else if (getMode == 2 && MySingleton.getListVeg().contains(shuffledListAllData[randomIndex])){
                    // vegs
                    maxScore++
                }

                binding.imageView.setImageResource(shuffledListAllData[randomIndex].Image)

                isClickable = true

                binding.imageView.setOnClickListener {
                    if(isClickable){
                        if(getMode == 1 && MySingleton.getListFruit().contains(shuffledListAllData[randomIndex])){
                            // fruit
                            myScore++

                        } else if (getMode == 2 && MySingleton.getListVeg().contains(shuffledListAllData[randomIndex])){
                            // vegs
                            myScore++
                        }
                        isClickable = false
                    }
                    binding.scoreText.text = "Score : ${myScore}"
                }

                handler.postDelayed(runnable,1300)
            }

        }

        handler.post(runnable)
    }



}