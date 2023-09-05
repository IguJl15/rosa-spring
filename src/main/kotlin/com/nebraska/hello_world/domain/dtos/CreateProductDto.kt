package com.nebraska.hello_world.domain.dtos

import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.entities.ProductStatus
import jakarta.validation.constraints.*

class CreateProductDto {
    @Size(max = 32)
    @NotBlank
    val name: String = ""

    @Max(180)
    @NotBlank
    val destination: String = ""

    @NotNull
    @Min(1)
    @Max(20)
    var anualRentability: Int = 0

    @NotNull
    @PositiveOrZero
    @Max(48)
    val minimalMonths: Int = 0

    @PositiveOrZero
    @Max(1)
    @NotNull
    var administrativeTaxes: Int = 0

    fun toProductEntity(): InvestmentProduct = InvestmentProduct(
        null,
        name,
        ProductStatus.available,
        destination,
        anualRentability / 100.0,
        minimalMonths,
        administrativeTaxes / 100.0
    )

}
