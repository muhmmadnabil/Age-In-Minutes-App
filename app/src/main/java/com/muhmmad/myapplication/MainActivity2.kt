package com.muhmmad.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = RecAdapter(getList())

    }

    private fun getList(): ArrayList<String> {
        val list = ArrayList<String>()

        for (i in 0..20) {
            list.add(i.toString())
        }

        return list
    }

}