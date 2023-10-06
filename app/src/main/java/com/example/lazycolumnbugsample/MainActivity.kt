package com.example.lazycolumnbugsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false) // Setting this to true alleviates the lazy column issue but app can no longer support edge to edge.

        setContentView(R.layout.activity_main)
        val navHostFragment = NavHostFragment.create(R.navigation.app_navigation)

        supportFragmentManager.commit {
            replace(R.id.app_nav_host_container, navHostFragment)
        }
    }
}

