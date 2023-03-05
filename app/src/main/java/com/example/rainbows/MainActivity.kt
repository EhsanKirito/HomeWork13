package com.example.rainbows

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rainbows.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        recyclerViewInitializer()


    }

    private fun recyclerViewInitializer(){
        val recyclerView:RecyclerView = binding.myRecyclerView
        val adaptor=Adaptor(fetchTextData(),fetchColorData())
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = adaptor
    }
    private fun fetchColorData():ArrayList<Int>{
        val item = ArrayList<Int>()
        item.add(Color.RED)
        item.add(Color.DKGRAY)
        item.add(Color.YELLOW)
        item.add(Color.GREEN)
        item.add(Color.BLUE)
        item.add(Color.CYAN)
        item.add(Color.MAGENTA)
        return item
    }
    private fun fetchTextData():ArrayList<String>{
        val item = ArrayList<String>()
        item.add("Red")
        item.add("DarkGrey")
        item.add("Yellow")
        item.add("Green")
        item.add("Blue")
        item.add("Cyan")
        item.add("Pink")
        return item
    }
}