package com.anushka.circlecalc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest{
    private lateinit var calcViewModel : CalcViewModel
    private lateinit var calculations: Calculations

    // 아키텍처 구성 요소에서 사용하는 백그라운드 실행기를 동기적으로 실행하는 실행기로 바꿔줌
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        // 해당 클래스 or 인터페이스 Mockito 객체를 만든다
        // 즉, 테스트용 객체를 Mockito를 이용하여 만드는 것임
        calculations = Mockito.mock(Calculations::class.java)

        // when을 이용하여 해당 메서드에 대해 정해진 값(thenReturn)을 반환하도록 설정
        // 즉, 테스트로써 calculations.calculateArea() 메서드를 실행하면 반드시 13.8474가 나오게됨
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(2.1)).thenReturn(13.188)
        // 위 코드로 인해 calcViewModel에는 무조건 thenReturn 값이 들어간다
        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData(){
        calcViewModel.calculateArea(2.1)
        val result = calcViewModel.areaValue.value!!.toDouble()
        assertEquals(13.8474, result, 0.0)
    }

    @Test
    fun calculateCircumference_radiusSent_updateLiveData(){
        calcViewModel.calculateCircumference(2.1)
        val result = calcViewModel.circumferenceValue.value!!.toDouble()
        assertEquals(13.188, result, 0.0)
    }
}