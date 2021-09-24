package com.anushka.circlecalc

class MyCalc : Calculations {

    private val pi = 3.14

    // 원의 둘레 구하기
    override fun calculateCircumference(redius: Double): Double {
        return 2 * pi * redius
    }

    // 원의 면적 구하기
    override fun calculateArea(redius: Double): Double {
        return pi * redius * redius
    }
}