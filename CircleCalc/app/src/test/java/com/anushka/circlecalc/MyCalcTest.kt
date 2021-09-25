package com.anushka.circlecalc

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MyCalcTest{
    private lateinit var myCalc : MyCalc

    // Before은 반드시 @Test가 실행되기 전에 먼저 실행된다
    @Before
    fun setUp(){
        myCalc = MyCalc()
    }

    // 원의 면적 구하기
    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult() {
        val result = myCalc.calculateArea(2.1)
        assertEquals(13.8474, result, 0.0)
    }

    // Test 어노테이션을 하면 이 부분을 테스트할 수 있게 왼쪽에 초록색 화살표가 생긴다
    @Test
    // 테스트에서 쓰이는 함수 이름은 아래와 같이 설정하는게 좋다(권장사항임)
    // SubjectUnderText_actionOrInput_resultState
    fun calculateCircumference_radiusGiven_returnsCorrectResult(){
        val result = myCalc.calculateCircumference(2.1)
        assertEquals(13.188, result, 0.0)
    }
}