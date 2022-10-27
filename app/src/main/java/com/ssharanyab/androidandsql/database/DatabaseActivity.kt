package com.hs1121.deligetsexample.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.hs1121.deligetsexample.databinding.ActivityDatabaseBinding

class DatabaseActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDatabaseBinding
    private lateinit var adapter:ArrayAdapter<String>
    private var userModelList:ArrayList<UserModel> = arrayListOf()
    private lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbHelper= DBHelper(this,null)
        binding.apply {
            addName.setOnClickListener {
                val name=enterName.text.toString()
                val age=enterAge.text.toString().toInt()
                dbHelper.addUser(name,age)
                printName.performClick()
            }
            printName.setOnClickListener {
                userModelList=dbHelper.getUser()
                val userList=userModelList.map { "${it.id}   ${it.name}   ${it.age}" }
                adapter=ArrayAdapter(this@DatabaseActivity,android.R.layout.simple_list_item_1,userList)
                list.adapter=adapter
            }
            list.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, index, _ ->
                dbHelper.deleteUser(userModelList[index].id)
                Toast.makeText(applicationContext, "deleted ${userModelList[index].name} ", Toast.LENGTH_SHORT).show()
                printName.performClick()
                true
            }
        }

    }
}
