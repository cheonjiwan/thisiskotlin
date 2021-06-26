package com.example.container

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.container.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

/*
    RecyclerViewAdapter는 개별 데이터에 대응하는 뷰홀더 클래스를 사용
    어댑터에 뷰홀더 클래스를 제네릭으로 지정해줘야 하므로 뷰홀더 클래스를 먼저 만들고
    어댑터 클래스를 생성하는 것이 더 편하다.
*/
class CustomAdapter: RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        /*
            뷰홀더가 사용하는 바인딩은 어댑터에서 생성한 후에 넘겨준다.
            이 어댑터에서 사용할 레이아웃의 이름이 item_recycler이기 때문에
            안드로이드에서 생성해주는 바인딩의 이름은 ItemRecyclerBinding이 된다.
        */
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }
}

class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
    init {
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "클릭된 아이템 = ${binding.textTitle.text}", Toast.LENGTH_LONG).show()
        }
    }

    fun setMemo(memo: Memo){
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = memo.title
        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(memo.timestamp)
        binding.textDate.text = formattedDate
    }
}