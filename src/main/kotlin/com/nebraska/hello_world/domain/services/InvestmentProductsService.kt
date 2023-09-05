package com.nebraska.hello_world.domain.services

import com.nebraska.hello_world.domain.dtos.CreateProductDto
import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.repositories.ProductsRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class InvestmentProductsService(
    private val repository: ProductsRepository
) {
    fun findAllProducts(): List<InvestmentProduct> {
        return repository.findAll()
    }

    fun findProductById(id: Long): Optional<InvestmentProduct> {
        return repository.findById(id)
    }

    fun createProduct(dto: CreateProductDto): InvestmentProduct {
        return repository.save(dto.toProductEntity())
    }
}