package com.example.month6_lesson2_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.month6_lesson2_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedItem = ArrayList<Int>()
    private var list = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = Adapter(list, this::clickItem, this::deleteItem)
        binding.rv.adapter = adapter
        initListeners()
        initList()
    }
    private fun initListeners(){
        binding.sendBtn.setOnClickListener {
            Intent(this, MainActivity2::class.java).apply {
                putIntegerArrayListExtra(KEY,selectedItem)
                startActivity(this)
            }
        }
    }
    private fun initList(){
        list.add(R.drawable.monkey1)
        list.add(R.drawable.monkey3)
        list.add(R.drawable.monkey4)
        list.add(R.drawable.monkey5)
        list.add(R.drawable.monkey6)
        list.add(R.drawable.monkey7)
        list.add(R.drawable.monkey8)
        list.add(R.drawable.monkey9)
        list.add(R.drawable.monkey10)
        list.add(R.drawable.monkey1)
        list.add(R.drawable.monkey3)
        list.add(R.drawable.monkey4)
        list.add(R.drawable.monkey5)
        list.add(R.drawable.monkey6)
        list.add(R.drawable.monkey7)
    }
    private fun deleteItem(url: Int){
        selectedItem.remove(list[list.indexOf(url)])
    }
    private fun clickItem(url: Int) {
        selectedItem.add(list[list.indexOf(url)])
    }
    companion object{
        const val KEY = "key"
    }
}