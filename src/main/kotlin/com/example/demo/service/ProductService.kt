package com.example.demo.service

import com.example.demo.entity.Product
import com.example.demo.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepo: ProductRepository,
) {
    fun getAll(): List<Product> {
        return productRepo.findAll().toList()
    }
}