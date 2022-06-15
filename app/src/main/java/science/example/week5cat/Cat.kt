package com.example.catsapp.ui

import androidx.lifecycle.ViewModel
import science.example.week5cat.data.Cat
import science.example.week5cat.data.CatService

class Cat : ViewModel() {

    private var currentCat = Cat()
    private val repository = CatService()
    private var favoriteCats: MutableList<Cat> = mutableListOf()

    suspend fun getCat(): Cat {
        currentCat = repository.getCat()[0]
        return currentCat
    }

    fun onLike() {
        favoriteCats.add(currentCat)
    }

    fun getFavoriteCats(): List<Cat> {
        return favoriteCats
    }
}