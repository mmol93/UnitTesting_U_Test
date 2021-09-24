package com.anushka.circlecalc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception

class CalcViewModel(
    private val calculations: Calculations
) : ViewModel() {

    // editText 뷰랑 연결되어 있음
    var radius = MutableLiveData<String>()

    var area = MutableLiveData<String>()
    val areaValue: LiveData<String>
        get() = area

    var circumference = MutableLiveData<String>()
    val circumferenceValue: LiveData<String>
        get() = circumference


    // 버튼 클릭 시 실시
    fun calculate() {
        try {
            val radiusDoubleValue = radius.value?.toDouble()
            if (radiusDoubleValue != null) {
                calculateArea(radiusDoubleValue)
                calculateCircumference(radiusDoubleValue)
            } else {
                area.value = null
                circumference.value = null
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
            area.value = null
            circumference.value = null
        }

    }

    fun calculateArea(radius: Double) {
        val calculatedArea = calculations.calculateArea(radius)
        area.value = calculatedArea.toString()
    }

    fun calculateCircumference(radius: Double) {
        val calculatedCircumference = calculations.calculateCircumference(radius)
        circumference.value = calculatedCircumference.toString()
    }

}