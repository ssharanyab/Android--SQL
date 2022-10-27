package com.hs1121.deligetsexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hs1121.deligetsexample.RecyclerView.RecyclerViewAdapter
import com.hs1121.deligetsexample.RecyclerView.VersionModel
import com.hs1121.deligetsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()   {
    private lateinit var binding: ActivityMainBinding

    private val list= mutableListOf(
                VersionModel("hasd",21.0,R.drawable.images),         VersionModel("iudasg",54.0,R.drawable.images),         VersionModel("oisdfsdf",22.0,R.drawable.images),
                VersionModel("hasd",21.0,R.drawable.images),         VersionModel("iudasg",54.0,R.drawable.images),         VersionModel("oisdfsdf",22.0,R.drawable.images),
                VersionModel("hasd",21.0,R.drawable.images),         VersionModel("iudasg",54.0,R.drawable.images),         VersionModel("oisdfsdf",22.0,R.drawable.images),
                VersionModel("hasd",21.0,R.drawable.images),         VersionModel("iudasg",54.0,R.drawable.images),         VersionModel("oisdfsdf",22.0,R.drawable.images),
                VersionModel("hasd",21.0,R.drawable.images),         VersionModel("iudasg",54.0,R.drawable.images),         VersionModel("oisdfsdf",22.0,R.drawable.images)
    )
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerViewAdapter=RecyclerViewAdapter(this,list)
        recyclerViewAdapter.setOnClickListener(object :RecyclerViewAdapter.OnClickListener{
            override fun onClick(item: VersionModel) {
                Toast.makeText(
                    this@MainActivity,
                    "${item.name}  ${item.version}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onLongCLick(position: Int) {
              list.removeAt(position)
                recyclerViewAdapter.setList(list)
                recyclerViewAdapter.notifyDataSetChanged()
            }

        })
        
        val linearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val gridLayoutManager=GridLayoutManager(this,3)
        binding.recyclerView.apply {
            layoutManager=gridLayoutManager
            adapter=recyclerViewAdapter
        }

    }
}

