package com.example.pdm_roteiro_09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun load1(view: View) {
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()

        ft.replace(R.id.fragment_content, Fragmento01())
        ft.commit()
    }

    fun load2(view: View) {
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragment_content, Fragmento02())
        ft.commit()
    }

    fun clear(view: View) {
        for (fragment in supportFragmentManager.fragments) {
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

    fun sobrepor(view: View) {
        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()

        ft.add(R.id.fragment_content, Fragmento01())
        ft.add(R.id.fragment_content, Fragmento02())

        ft.commit()
    }
}