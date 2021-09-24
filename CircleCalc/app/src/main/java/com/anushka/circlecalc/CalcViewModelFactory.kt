package com.anushka.circlecalc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalcViewModelFactory(
    // 해당 변수를 초기화
    private val calculations: Calculations
) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CalcViewModel(calculations) as T
    }
}