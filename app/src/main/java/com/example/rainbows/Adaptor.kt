package com.example.rainbows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptor(private var colorNames:ArrayList<String>, private val colors:ArrayList<Int>):RecyclerView.Adapter<Adaptor.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textItems:TextView = itemView.findViewById(R.id.txtItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // set the text and color of the rv items
        holder.textItems.text = colorNames[position]
        holder.textItems.setBackgroundColor(colors[position])

        holder.textItems.setOnClickListener {
            val deletedColorText = colorNames[position]
            //remove the color and text from input arrays
            colorNames.remove(colorNames[position])
            colors.remove(colors[position])
            // make backup arrays to change the text
            val clickedColorNameArray = arrayListOf<String>()
            val colorNameArrayStorage = colorNames
            // this for fills the array with the deleted color name inside it
            for (i in colorNames)  clickedColorNameArray.add(deletedColorText)
            // we change the color names to deleted color name
            colorNames = clickedColorNameArray
            notifyDataSetChanged()
            // after 5 seconds we can change color names back to what it was before with handler
            android.os.Handler().postDelayed({
                colorNames = colorNameArrayStorage
                notifyDataSetChanged()
            },5000)
        }
    }

    override fun getItemCount(): Int {
        return colorNames.size
    }
}