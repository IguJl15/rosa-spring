package com.nebraska.hello_world.domain.dtos


import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.entities.ProductStatus
import jakarta.validation.constraints.*

open class CreateProductDto {
    @Size(max = 32)
    @NotBlank
    var name: String? = null

    @Size(max = 180)
    @NotBlank
    var destination: String? = null

    @NotNull
    @Min(1)
    @Max(20)
    var anualRentability: Int? = null

    @NotNull
    @PositiveOrZero
    @Max(48)
    var minimalMonths: Int? = null

    @PositiveOrZero
    @Max(100)
    @NotNull
    var administrativeTaxes: Int? = null

    open fun toProductEntity(): InvestmentProduct = InvestmentProduct(
        null,
        name!!,
        ProductStatus.Available,
        destination!!,
        anualRentability!! / 100.0,
        minimalMonths!!,
        administrativeTaxes!! / 100.0
    )

}
