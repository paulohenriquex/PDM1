package com.example.pdm_roteiropratico_11;

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2 // Necessário para ViewPager
import com.google.android.material.tabs.TabLayout // Necessário para as abas
import com.google.android.material.tabs.TabLayoutMediator // Necessário para ligar as abas ao ViewPager

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // O layout activity_main.xml deve conter os IDs viewPager e tabLayout.

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        // Associa o adaptador ao ViewPager2
        viewPager.adapter = MyPagerAdapter(this)

        // Liga as abas (TabLayout) ao conteúdo (ViewPager)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Cadastro"
                1 -> "Visualização"
                else -> ""
            }
        }.attach()
    }
}