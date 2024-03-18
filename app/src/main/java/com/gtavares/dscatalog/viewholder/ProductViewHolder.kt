package com.gtavares.dscatalog.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.gtavares.dscatalog.databinding.CardViewBinding
import com.gtavares.dscatalog.model.Product
import com.gtavares.dscatalog.utils.formatToBrazilianReal
import com.squareup.picasso.Picasso

class ProductViewHolder(val binding: CardViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product) {
        Picasso.get().load(product.imgUrl).into(binding.imageView)
        binding.txtViewName.text = product.name
        binding.txtViewPrice.text = product.price.formatToBrazilianReal()
    }

}