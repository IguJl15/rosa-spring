

import java.math.BigDecimal


/// Nome até 32 caracteres    | 	Status: 'Disponível' ou 'Indisponível'
/// Destinação até 180 caracteres
/// Taxa Rentabilidade a.a. (%): inteiro entre 1% e 20%, sem decimais
/// Prazo mínimo para Realização (meses): 0 a 48 meses, qualquer valor.
/// Taxa de Administração (%): Quanto do ganho a ROSA fica? 
data class PreFixedStock(
    val name: String, 
    val status: ProductStatus, 
    val destination: String,
    val anualRentability: BigDecimal, 
    val minimalMonths: Int,
    val administrativeTaxes: BigDecimal,
)

enum class ProductStatus {
    available,
    unavailable;
}