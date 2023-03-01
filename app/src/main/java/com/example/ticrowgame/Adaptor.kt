package com.example.ticrowgame

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class Adaptor(private val item: ArrayList<Int>) : RecyclerView.Adapter<Adaptor.ViewHolder>() {
    val viewModel = FourRowViewModel()
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val btnView :Button = itemView.findViewById(R.id.btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.btnView.text = viewModel.playMatrix[position].toString()
        holder.btnView.setBackgroundColor(
            (if (viewModel.playMatrix[position]==1) Color.RED
            else if (viewModel.playMatrix[position] == 2) {
                Color.BLUE
            } else{
                Color.GRAY
            })
        )


        holder.btnView.setOnClickListener {
            viewModel.turnPlayed(position)
            val w1 = viewModel.seeIfWonHorizontal()
            val w2 = viewModel.seeIfWonVertical()
            val w3 = viewModel.seeIfWonDiagonalOne()
            val w4 = viewModel.seeIfWonDiagonalTwo()
            if (w1 || w2 || w3 || w4) {
                viewModel.playMatrix = Array(viewModel.btnCount) {(viewModel.counter+1)%2+1}
            }
            notifyDataSetChanged()
        }
    }
}