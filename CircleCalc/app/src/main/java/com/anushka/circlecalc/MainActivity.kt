package com.anushka.circlecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.circlecalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CalcViewModel
    lateinit var factory: CalcViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 여긴 그냥 데이터 바인딩 및 뷰모델 연결 시기는 거만 있음
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // factory를 이용하여 viewModel 초기화
        // -> viewModel 클래스에 있는 calculateArea(), calculateCircumference() 함수를 사용하기 위함임
        factory = CalcViewModelFactory(MyCalc())
        // 뷰모델 객체 생성
        viewModel = ViewModelProvider(this, factory)
            .get(CalcViewModel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}