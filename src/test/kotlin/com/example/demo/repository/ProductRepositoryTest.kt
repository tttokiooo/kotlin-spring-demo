package com.example.demo.repository

import com.example.demo.entity.Product
import com.example.demo.extension.findByIdOrNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
class ProductRepositoryTest @Autowired constructor(
    private val productRepo: ProductRepository,
) {
    private var products: List<Product> = emptyList()

    @BeforeEach
    fun setup() {
        products = listOf(
            Product(name = "みかん", price = 500),
            Product(name = "りんご", price = 500),
        )
        productRepo.saveAll(products)
    }

    @Test
    fun findAll() {
        val actual = productRepo.findAll()
        assertEquals(2, actual.count())
    }

    @Test
    fun findById() {
        val productId = products.first().id
        val actual = productRepo.findByIdOrNull(productId)
        assertNotNull(actual)
    }
}