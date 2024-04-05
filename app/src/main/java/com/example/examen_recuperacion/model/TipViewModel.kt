package com.example.examen_recuperacion.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData as MutableLiveData1

class TipViewModel : ViewModel() {
        private val _tips = MutableLiveData1<List<TipModel>>()
        val tips: LiveData<List<TipModel>> = _tips

        fun addTip(amount: Double) {
            val currentTips = _tips.value ?: emptyList()
            _tips.value = currentTips + TipModel(amount)
        }

        fun calculateTotalAmount(): Double {
            return _tips.value?.sumByDouble { it.amount } ?: 0.0
        }
    }


