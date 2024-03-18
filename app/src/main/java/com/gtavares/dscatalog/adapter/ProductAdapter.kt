package com.gtavares.dscatalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gtavares.dscatalog.databinding.CardViewBinding
import com.gtavares.dscatalog.model.Product
import com.gtavares.dscatalog.viewholder.ProductViewHolder

class ProductAdapter() : RecyclerView.Adapter<ProductViewHolder>() {

    private var products: List<Product> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = CardViewBinding.inflate(inflater, parent, false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    fun attackProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
}