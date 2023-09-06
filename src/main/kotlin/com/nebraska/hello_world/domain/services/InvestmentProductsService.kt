package com.nebraska.hello_world.domain.services

import com.nebraska.hello_world.domain.dtos.CreateProductDto
import com.nebraska.hello_world.domain.dtos.UpdateProductDto
import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.errors.ProductNotFound
import com.nebraska.hello_world.domain.repositories.ProductsRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse

@Service
class InvestmentProductsService(
    private val repository: ProductsRepository
) {
    fun findAllProducts(): List<InvestmentProduct> {
        return repository.findAll()
    }

    fun findProductById(id: Long): InvestmentProduct {
        val product = repository.findById(id)

        return product.getOrElse { throw ProductNotFound(id) }
    }

    fun createProduct(dto: CreateProductDto): InvestmentProduct {
        return repository.save(dto.toProductEntity())
    }

    fun updateProduct(product: UpdateProductDto): InvestmentProduct {
        if (repository.existsById(product.id!!)) {
            return repository.save(product.toProductEntity())
        } else throw ProductNotFound(product.id)
    }

    fun deleteProduct(id: Long) {
        repository.deleteById(id)
    }
}