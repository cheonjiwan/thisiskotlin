package com.example.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {

    var mainActivity: MainActivity? = null
    lateinit var binding:FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,    // 레이아웃 파일을 로드하기 위한 레이아웃 인플레이터
        container: ViewGroup?,       // 프래그먼트 레이아웃이 배치되는 부모 레이아웃(액티비티 레이아웃)
        savedInstanceState: Bundle?  // 상태 값 저장을 위한 보조 도구. -> 액티비티의 onCreate의 파라미터와 동일하게 동작
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener { mainActivity?.goDetail() }
        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}"
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 넘어온 Context를 캐스팅해서 MainActivity에 담기
        if(context is MainActivity) mainActivity = context
    }

    fun setValue(value:String){
        binding.textFromActivity.text = value
    }
}