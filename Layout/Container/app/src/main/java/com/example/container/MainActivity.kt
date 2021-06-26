package com.example.container

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.container.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var data = listOf("- 선택하세요 -","1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.result.text = data.get(position)
            }
        }

        var dataOfRecycler:MutableList<Memo> = loadData()
        var adapter2 = CustomAdapter()
        adapter2.listData = dataOfRecycler
        binding.recyclerView.adapter = adapter2
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun loadData(): MutableList<Memo>{
        val data: MutableList<Memo> = mutableListOf()

        for (no in 1..100){
            var title = "번호 ${no}"
            var date = System.currentTimeMillis()
            var memo = Memo(no,title,date)
            data.add(memo)
        }
        return data
    }
}