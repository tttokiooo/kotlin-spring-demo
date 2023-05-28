package com.example.demo.repository

import com.example.demo.entity.Customer
import com.example.demo.entity.FavoriteProduct
import com.example.demo.entity.Product
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class FavoriteProductRepositoryTest @Autowired constructor(
    private val productRepo: ProductRepository,
    private val customerRepo: CustomerRepository,
    private val favProductRepo: FavoriteProductRepository,
) {
    private var products: List<Product> = emptyList()

    @BeforeEach
    fun setup() {
        products = productRepo.saveAll(
            listOf(
                Product(name = "みかん", price = 500),
                Product(name = "りんご", price = 500),
            )
        )

        val customer = customerRepo.save(Customer(name = "たろう"))

        val favProducts = products.map { product ->
            FavoriteProduct(customerId = customer.id, productId = product.id)
        }
        favProductRepo.saveAll(favProducts)
    }

    @Test
    fun findAll() {
        val actual = favProductRepo.findAll()
        assertEquals(2, actual.count())
    }

    @Test
    fun findByProductId() {
        val productId = products.first().id
        val actual = favProductRepo.findByProductId(productId)
        assertEquals(1, actual.count())
    }
}