package com.example.demo.entity

import com.example.demo.type.IdValue
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

typealias FavoriteProductId = IdValue<FavoriteProduct>

class FavoriteProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: FavoriteProductId = FavoriteProductId(0),
    var customerId: CustomerId,
    var productId: ProductId,
)