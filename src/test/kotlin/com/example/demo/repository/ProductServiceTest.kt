package com.example.demo.repository

import com.example.demo.entity.Product
import com.example.demo.service.ProductService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductRepositoryTest @Autowired constructor(
    private val productRepo: ProductRepository,
) {
    @Test
    fun list() {
        val products = listOf(
            Product(name = "みかん", price = 500),
            Product(name = "りんご", price = 500),
        )
        productRepo.saveAll(products)

        val actual = productRepo.findAll()
        assertEquals(2, actual.count())
    }
}