package com.example.exercise_recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.language_item_layout.view.*

class LanguageRecycleAdapter(private val languageList: MutableList<String>) : RecyclerView.Adapter<LanguageViewHolder>() {

    lateinit var listener: CustomClickListener

    // yang mengatur layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return  LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        println("$position ${languageList[position]}")
        holder.orderNumber.text = position.plus(1).toString()
        holder.languageName.text = languageList[position]
        holder.itemView.setOnClickListener{
              listener.onItemClicked(it, languageList[position])
        }
        holder.itemView.delete_button.setOnClickListener {
            listener.deleteButtonClicked(it, position, languageList[position])
        }
        //holder.itemView.setOnClickListener(holder)
    }

}

class LanguageViewHolder(v: View): RecyclerView.ViewHolder(v) {
    // akan mencari view yang punya text view dengan id order number
    val orderNumber = v.findViewById<TextView>(R.id.order_number)
    val languageName = v.findViewById<TextView>(R.id.language_name)

//    override fun onClick(v: View?) {
//        Toast.makeText(v?.context, "${languageName.text}", Toast.LENGTH_LONG).show()
//    }
}

