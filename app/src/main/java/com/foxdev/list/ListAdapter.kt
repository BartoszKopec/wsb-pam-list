package com.foxdev.list

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

// class with private field _items of string array type
class ListAdapter(private val _items:Array<String>) : RecyclerView.Adapter<ItemHolder>(){

    private lateinit var _parent: ViewGroup

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        _parent=parent

        // capturing of layout box for one item
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        val viewHolder: ItemHolder = ItemHolder(itemLayout)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return _items.count()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = _items[position]

        // capturing of label in item box and its layout
        val titleView = holder.itemView.findViewById<TextView>(R.id.list_item_title)
        val layout=holder.itemView.findViewById<ConstraintLayout>(R.id.list_item_layout)

        titleView.text = item

        // setting color with the current position
        val oddColor = ContextCompat.getColor(_parent.context, R.color.colorPrimary)
        val evenColor = ContextCompat.getColor(_parent.context, R.color.colorPrimaryDark)
        layout.background = ColorDrawable(if(position%2==0) evenColor else oddColor)
    }

}