package com.hs1121.deligetsexample.listView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hs1121.deligetsexample.databinding.ActivityFullScreenBinding

class FullScreenActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFullScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name:String= intent.getStringExtra("Name")?:"No Name"
        val age:String=intent.getStringExtra("Age")?:"No Age"

        binding.Name.text=name
        binding.Age.text=age


    }
}