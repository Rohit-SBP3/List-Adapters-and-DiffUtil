package com.example.listadapteranddiffutil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_main)
        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1,"J","Java")
        val p2 = ProgrammingItem(2,"K","Kotlin")
        val p3 = ProgrammingItem(3,"D","Dart")

        adapter.submitList(listOf<ProgrammingItem>(p1,p2,p3))

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

        // Helps to execute code on main thread after a certain time.
        Handler(Looper.getMainLooper()).postDelayed(Runnable{

            val p4 = ProgrammingItem(4,"R","Rust")
            val p5 = ProgrammingItem(5,"J","JavaScript")
            val p6 = ProgrammingItem(6,"G","Go Lang")
            val p7 = ProgrammingItem(7,"C++","C++")

            adapter.submitList(listOf<ProgrammingItem>(p4,p5,p6,p7))

        }, 4000)

    }
}