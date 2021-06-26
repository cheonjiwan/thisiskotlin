package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.fragment.databinding.FragmentReceiverBinding

class ReceiverFragment : Fragment() {

    lateinit var binding:FragmentReceiverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReceiverBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request"){ requestKey, bundle ->  
            // 실제 값은 bundle안에 Map형태로 담겨 있다.
            bundle.getString("valueKey")?.let {
                binding.textView.setText(it)
            }
        }
    }
}