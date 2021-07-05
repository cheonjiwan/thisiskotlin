package com.example.httpurlconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.httpurlconnection.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            buttonRequest.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        var urlText = editUrl.text.toString()
                        if(!urlText.startsWith("https")){
                            urlText = "http://${urlText}"
                        }

                        val url = URL(urlText)
                        val urlConnection = url.openConnection() as HttpURLConnection
                        urlConnection.requestMethod = "GET"
                        if (urlConnection.responseCode == HttpURLConnection.HTTP_OK){
                            val streamReader = InputStreamReader(urlConnection.inputStream)
                            val buffered = BufferedReader(streamReader)

                            val content = StringBuilder()
                            while (true){
                                val line = buffered.readLine()?: break
                                content.append(line)
                            }

                            buffered.close()
                            urlConnection.disconnect()
                            launch(Dispatchers.Main){
                                textContent.text = content.toString()
                            }
                        }
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}