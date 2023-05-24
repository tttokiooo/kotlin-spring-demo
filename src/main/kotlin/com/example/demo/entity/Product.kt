package com.example.demo.entity

import com.example.demo.type.IdValue
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

typealias ProductId = IdValue<Product>

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: ProductId = ProductId(0),
    var name: String,
    var price: Int,
)
