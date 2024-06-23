package com.nextin.cartapiapplication

data class Cart(
    val discountedTotal: Double,
    val id: Int,
    val products: ArrayList<Product>,
    val total: Double,
    val totalProducts: Int,
    val totalQuantity: Int,
    val userId: Int
)