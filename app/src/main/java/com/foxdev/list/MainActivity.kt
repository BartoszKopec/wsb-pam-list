package com.foxdev.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // generating a list of animals
        val items:Array<String> = Array(100){""}
        val animals = listOf<String>("Cat", "Dog", "Fox", "Lizard")
        for (i in 0..items.count()-1) items[i] = animals[Random.nextInt(0,4)]

        // capturing of RecycleView view from layout file
        val list = findViewById<RecyclerView>(R.id.list)

        // setting layout type - vertical linear and adapter
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ListAdapter(items)
    }
}
