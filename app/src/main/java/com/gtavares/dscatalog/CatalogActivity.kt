package com.gtavares.dscatalog

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.GridLayoutManager
import com.gtavares.dscatalog.adapter.ProductAdapter
import com.gtavares.dscatalog.api.RetrofitHelper
import com.gtavares.dscatalog.databinding.ActivityCatalogBinding
import com.gtavares.dscatalog.model.PageResponse
import com.gtavares.dscatalog.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class CatalogActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCatalogBinding.inflate(layoutInflater)
    }
    private val dsCatalogAPI = RetrofitHelper.recoverData()
    private val adapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initialiseToolbar()
        configRecycleview()
        recover()
        searchView()
    }

    private fun searchView() {
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterProductByName(newText)
                return true
            }

        })
    }

    private fun filterProductByName(newText: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var response: Response<PageResponse<Product>>? = null
                response = dsCatalogAPI.recoverProductsByName(newText)

                if (response.isSuccessful) {

                    val products = response.body()

                    if (products != null) {

                        withContext(Dispatchers.Main) {
                            adapter.attackProducts(products.content)
                        }

                    } else {

                        Log.e("DSCatalog", "Lista vazia")

                    }
                } else {

                    Log.e("DSCatalog", "cod ${response.code()} message: ${response.message()}")

                }

                binding.progressBar.visibility = View.GONE

            } catch (e: Exception) {
                Log.e("DSCatalog", e.message.toString())
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun recover() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var response: Response<PageResponse<Product>>? = null
                response = dsCatalogAPI.recoverProducts()

                if (response.isSuccessful) {

                    val products = response.body()

                    if (products != null) {

                        withContext(Dispatchers.Main) {
                            adapter.attackProducts(products.content)
                        }

                    } else {

                        Log.e("DSCatalog", "Lista vazia")

                    }
                } else {

                    Log.e("DSCatalog", "cod ${response.code()} message: ${response.message()}")

                }

                binding.progressBar.visibility = View.GONE

            } catch (e: Exception) {
                Log.e("DSCatalog", e.message.toString())
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun configRecycleview() {
        val gridLayoutManager = GridLayoutManager(this, 1)
        binding.recyclerView.layoutManager = gridLayoutManager
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)

    }

    private fun initialiseToolbar() {
        val toolbar = binding.includeToolbarCatalog.tbMain
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = getString(R.string.app_name)
            setDisplayHomeAsUpEnabled(true)
        }
    }
}
