package com.hs1121.deligetsexample.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import coil.transform.CircleCropTransformation
import com.hs1121.deligetsexample.R
import com.hs1121.deligetsexample.databinding.VersionGridItemBinding

class RecyclerViewAdapter(
    private val context: Context,
    private var list:List<VersionModel>):RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private lateinit var listener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val binding=VersionGridItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.initView(list[position],context)
        holder.binding.root.setOnClickListener {
            listener.onClick(list[position])
        }
        holder.binding.root.setOnLongClickListener {
            listener.onLongCLick(position)
             true
        }
    }

    override fun getItemCount(): Int {
      return list.size
    }


    class MyViewHolder( val binding:VersionGridItemBinding,):RecyclerView.ViewHolder(binding.root) {

        fun initView(item:VersionModel,context: Context){
            binding.name.text=item.name
            binding.version.text=item.version.toString()
            binding.image.load("https://source.unsplash.com/random/300x200") {
                crossfade(true)
                placeholder(R.drawable.ic_android)
                transformations(CircleCropTransformation())
            }
        }

    }

    interface OnClickListener{
        fun onClick(item: VersionModel)
        fun onLongCLick(position: Int)
    }
    fun setList(list:List<VersionModel>){
        this.list=list;
    }

    /**
     * set the click listener to the recyclerView
     */
    fun setOnClickListener(listener:OnClickListener){
        this.listener=listener
    }
}