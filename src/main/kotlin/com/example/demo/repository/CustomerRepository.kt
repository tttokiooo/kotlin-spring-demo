package com.example.demo.repository

import com.example.demo.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long>