/*
package com.develop.linechartkotlin

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val numList: ArrayList<Numbers>):
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var selectedItem = 0


    var listener: OnClickListener? = null

    fun setOnClickListeners(listener: OnClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_layout, parent, false)
        return ViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

                        holder.bindItems(numList[position])
    }

    override fun getItemCount(): Int {

        return numList.size
    }

    fun updateAdapter(numberList: Numbers, position: Int) {
        this.numList[position] = numberList
        notifyItemChanged(position, this.numList[position])
    }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

               fun bindItems(list: Numbers){
                   val numText = itemView.findViewById<TextView>(R.id.tv_number)
                   numText.text = list.number

               }

        override fun onClick(v: View?) {
            when (v!!.id) {
                R.id.iv_left_arrow -> {
                    listener!!.getPreviousData(adapterPosition)
                }
                R.id.iv_right_arrow -> {
                    listener!!.getNextData(adapterPosition)
                }
            }

        }
    }

    interface OnClickListener {
        fun getNextData(adapterPosition: Int)
        fun getPreviousData(adapterPosition: Int)


    }
}
*/
