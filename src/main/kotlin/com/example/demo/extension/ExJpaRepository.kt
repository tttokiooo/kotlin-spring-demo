package com.example.demo.extension

import com.example.demo.type.IdValue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

fun <T> JpaRepository<T, Long>.findByIdOrNull(id: IdValue<T>): T? {
    return this.findByIdOrNull(id.value)
}