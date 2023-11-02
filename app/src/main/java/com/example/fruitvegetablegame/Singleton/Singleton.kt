package com.example.fruitvegetablegame.Singleton

import com.example.fruitvegetablegame.Data.DataClass

object MySingleton {
    private lateinit var listFruit:List<DataClass>
    private lateinit var listMapVeg:List<DataClass>

    fun getListFruit(): List<DataClass> {
        return listFruit
    }
    fun setListFruit(data: List<DataClass>) {
        listFruit = emptyList()
        listFruit = data.toMutableList()
    }

    fun getListVeg(): List<DataClass> {
        return listMapVeg
    }
    fun setListVeg(data: List<DataClass>) {
        listMapVeg = emptyList()
        listMapVeg = data.toMutableList()
    }
}