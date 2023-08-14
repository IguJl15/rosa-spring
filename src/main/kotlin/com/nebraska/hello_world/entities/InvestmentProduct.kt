package com.nebraska.hello_world.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.math.BigDecimal


/// Nome até 32 caracteres    | 	Status: 'Disponível' ou 'Indisponível'
/// Destinação até 180 caracteres
/// Taxa Rentabilidade a.a. (%): inteiro entre 1% e 20%, sem decimais
/// Prazo mínimo para Realização (meses): 0 a 48 meses, qualquer valor.
/// Taxa de Administração (%): Quanto do ganho a ROSA fica? 
@Entity()
class InvestmentProduct(
    @Id
    @GeneratedValue
    private val id: Long? = null,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val status: ProductStatus = ProductStatus.available,

    @Column(nullable = false)
    val destination: String = "",

    @Column(nullable = false)
    val anualRentability: BigDecimal = BigDecimal(0),

    @Column(nullable = true)
    val minimalMonths: Int? = null,

    @Column(nullable = false)
    val administrativeTaxes: BigDecimal = BigDecimal(0),
)

enum class ProductStatus {
    available,
    unavailable
}