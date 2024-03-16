package com.gtavares.dscatalog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import com.gtavares.dscatalog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initialiseToolbar()
        initialiseEventClick()
    }

    private fun initialiseEventClick() {
        binding.btnInit.setOnClickListener {
            startActivity(
                Intent(applicationContext, CatalogActivity::class.java)
            )
        }
    }

    private fun initialiseToolbar() {
        val toolbar = binding.includeMainToolbar.tbMain
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
        }

        addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.main_menu, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when (menuItem.itemId) {
                        R.id.item_home -> {
                            startActivity(
                                Intent(applicationContext, MainActivity::class.java)
                            )
                        }

                        R.id.item_catalago -> {
                            startActivity(
                                Intent(applicationContext, CatalogActivity::class.java)
                            )
                        }

                        R.id.item_adm -> {
                            startActivity(
                                Intent(applicationContext, AdmActivity::class.java)
                            )
                        }

                    }
                    return true
                }
            }
        )
    }
}