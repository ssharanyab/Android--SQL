package com.hs1121.deligetsexample.listView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.hs1121.deligetsexample.databinding.GridLayoutBinding

class MyAdapter(
    private val context: Context,
    private val list: List<Model>,
    private val onItemClick:(Model)->Unit
) : BaseAdapter() {
    override fun getCount()= list.size

    override fun getItem(pos: Int)= list[pos]

    override fun getItemId(pos: Int) = pos.toLong()

    override fun getView(pos: Int, v: View?, parent: ViewGroup?): View {
        val view= GridLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        list[pos].apply {
            view.Name.text =name;
            view.Age.text=age.toString()
        }
        view.root.setOnClickListener {
            onItemClick(list[pos])
        }
        return view.root;
    }
}