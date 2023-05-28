package com.example.demo.repository

import com.example.demo.entity.FavoriteProduct
import com.example.demo.entity.ProductId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FavoriteProductRepository : JpaRepository<FavoriteProduct, Long> {
    @Query("SELECT favProduct FROM FavoriteProduct favProduct WHERE favProduct.productId = :productId")
    fun findByProductId(productId: ProductId): List<FavoriteProduct>
}