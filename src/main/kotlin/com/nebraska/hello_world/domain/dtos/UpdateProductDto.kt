package com.nebraska.hello_world.domain.dtos

import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.entities.ProductStatus
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

class UpdateProductDto
    : CreateProductDto() {

    @NotNull
    @Positive
    val id: Long? = null

    @NotNull
    val status: ProductStatus? = null

    override fun toProductEntity(): InvestmentProduct {
        return super.toProductEntity().copy(id = this.id, status = this.status!!)
    }
}