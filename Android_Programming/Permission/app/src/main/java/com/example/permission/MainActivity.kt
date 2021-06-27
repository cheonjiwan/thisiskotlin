package com.example.permission

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnCamera.setOnClickListener { checkPermission() }
    }

    fun checkPermission(){
        // 1. 위험권한(camera) 권한 승인상태 가져오기
        val cameraPermission = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)

        if(cameraPermission == PackageManager.PERMISSION_GRANTED){
            // 승인이면 프로그램 진행
            startProcess()
        }else {
            // 미승인이면 권한 요청
            requestPermission()
        }
    }

    fun startProcess(){
        Toast.makeText(this,"카메라를 실행합니다",Toast.LENGTH_LONG).show()
    }

    fun requestPermission(){
        // 2. 권한 요청
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),99)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, // 요청한 주체를 확인하는 코드
        permissions: Array<out String>, // 요청한 권한 목록
        grantResults: IntArray // 권한 목록에 대한 승인/미승인 값
    ) {
        when(requestCode) {
            99 -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startProcess()
                } else {
                    finish()
                }
            }
        }
    }
}