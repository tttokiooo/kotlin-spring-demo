package com.example.demo.repository

import com.example.demo.entity.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long>