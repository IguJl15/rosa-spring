package com.nebraska.hello_world.domain.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


/// Nome até 32 caracteres | Status: 'Disponível' ou 'Indisponível'
/// Destinação até 180 caracteres
/// Taxa Rentabilidade a.a. (%): inteiro entre 1% e 20%, sem decimais
/// Prazo mínimo para Realização (meses): 0 a 48 meses, qualquer valor.
/// Taxa de Administração (%): Quanto do ganho a ROSA fica? 
@Entity
data class InvestmentProduct(
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val status: ProductStatus = ProductStatus.Available,

    @Column(nullable = false)
    val destination: String = "",

    @Column(nullable = false)
    val anualRentability: Double = 0.0,

    @Column(nullable = true)
    val minimalMonths: Int? = null,

    @Column(nullable = false)
    val administrativeTaxes: Double = 0.0,
)

enum class ProductStatus {
    Available,
    Unavailable
}