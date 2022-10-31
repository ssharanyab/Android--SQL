package com.hs1121.deligetsexample.canvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hs1121.deligetsexample.databinding.ActivityCustomViewBinding
import kotlinx.coroutines.*

class CustomViewActivity : AppCompatActivity() {


    private lateinit var binding:ActivityCustomViewBinding
    private lateinit var job:CoroutineScope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        job= CoroutineScope(Dispatchers.Main)

//        binding.fan.setOnMotionEvent(object :FanView.OnMotionEvent{
//            override fun actionDown(view: FanView) {
//               job.launch {
//                   while (this.isActive){
//                       view.startVal++
//                       view.invalidate()
//                       delay(10)
//                       ensureActive()
//
//                   }
//               }
//            }
//
//            override fun actionUp(view: FanView) {
//                job.cancel()
//                view.startVal=0f
//            }
//
//
//        })
    }


}