package com.example.demo.entity

import com.example.demo.type.IdValue
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

typealias CustomerId = IdValue<Customer>

@Entity
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: CustomerId = CustomerId(0),
    var name: String,
)