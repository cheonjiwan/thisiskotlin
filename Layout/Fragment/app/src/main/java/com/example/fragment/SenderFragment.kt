package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.fragment.databinding.FragmentReceiverBinding
import com.example.fragment.databinding.FragmentSenderBinding

class SenderFragment : Fragment() {

    lateinit var binding: FragmentSenderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSenderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnYes.setOnClickListener {
            var bundle = bundleOf("valueKey" to "Yes")
            setFragmentResult("request",bundle)
        }

        binding.btnNo.setOnClickListener {
            var bundle = bundleOf("valueKey" to "No")
            setFragmentResult("request",bundle)
        }
    }
}