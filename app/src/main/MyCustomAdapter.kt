package com.hs1121.deligetsexample.listView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.hs1121.deligetsexample.databinding.GridLayoutBinding

class MyCustomAdapter(context: Context, resource: Int, private val objects: MutableList<Model>, private  val onClickListener:(Model)->Unit) :
    ArrayAdapter<Model>(context, resource, objects) {

//    override fun getItem(position: Int): Model? {
//        return objects[position]
//    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view=GridLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        view.Name.text=objects[position].name
        view.Age.text=objects[position].age.toString()
        view.root.setOnClickListener {
            onClickListener(objects[position])
        }
        return view.root // super.getView(position, convertView, parent)
    }
}