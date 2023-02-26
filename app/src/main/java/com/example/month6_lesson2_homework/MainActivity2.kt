package com.example.month6_lesson2_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.month6_lesson2_homework.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var list = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent.getIntegerArrayListExtra(MainActivity.KEY)
        if(intent != null){
            list = intent
        }
        val adapter = Adapter(list, null, null)
        binding.rv.adapter = adapter
    }
}