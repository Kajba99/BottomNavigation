package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private val homefragment = FirstFragment()
    private val profilefragment = SecondFragment()
    private val settingsfragment = ThirdFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottom = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replace(homefragment)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.firstFragment -> replace(homefragment)
                R.id.secondFragment -> replace(profilefragment)
                R.id.thirdFragment -> replace(settingsfragment)
            }
            true
        }


    }

    private fun replace(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

}