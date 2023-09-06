package com.nebraska.hello_world.api.controllers

import com.nebraska.hello_world.domain.dtos.CreateProductDto
import com.nebraska.hello_world.domain.dtos.UpdateProductDto
import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.errors.ProductNotFound
import com.nebraska.hello_world.domain.services.InvestmentProductsService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@ApiV1RestController
class ProductsRestController(
    private val service: InvestmentProductsService
) {
    @Operation(summary = "Get all the investment products available")
    @GetMapping("/products")
    fun getAll(): List<InvestmentProduct> {
        return service.findAllProducts()
    }

    @Operation(summary = "Get a specific investment product")
    @GetMapping("/products/{id}")
    fun getProduct(@PathVariable id: Long): InvestmentProduct {
        return service.findProductById(id)
    }

    @Operation(summary = "Create a new investment product")
    @PostMapping("/products")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun createProduct(@Valid @RequestBody newProduct: CreateProductDto): InvestmentProduct {
        return service.createProduct(newProduct)
    }

    @Operation(summary = "Update a existing investment product")
    @PatchMapping("/products/{id}")
    fun updateProduct(@Valid @RequestBody product: UpdateProductDto): InvestmentProduct {
        return service.updateProduct(product)
    }

    @Operation(summary = "Delete a existing investment product")
    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduct(@PathVariable id: Long) {
        service.deleteProduct(id)
    }


    @ExceptionHandler(ProductNotFound::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleValidationExceptions(ex: ProductNotFound): Map<String, Any>? {
        return ex.toMap()
    }
}