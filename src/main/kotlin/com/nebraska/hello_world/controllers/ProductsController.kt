package com.nebraska.hello_world.controllers

import com.nebraska.hello_world.entities.InvestmentProduct
import com.nebraska.hello_world.entities.ProductStatus
import com.nebraska.hello_world.repositories.ProductsRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.math.BigDecimal


@Controller
@RequestMapping("/products")
class ProductsController(
    val repository: ProductsRepository
) {

    @GetMapping(value = ["/", ""])
    fun index(model: Model): String {
        val products = repository.findAll()

        model.addAttribute("products", products)
        model.addAttribute("newProduct", InvestmentProduct())

        return "products/products_list"
    }

    @PostMapping(value = ["/", ""])
    fun new(@ModelAttribute newProduct: InvestmentProduct): String {
        repository.save(newProduct);

        return "redirect:/products/"
    }

    @GetMapping("/create")
    fun createNew(model: Model): String {
        repository.save(
            InvestmentProduct(
                id = null,
                name = "Produto a bla bleh",
                status = ProductStatus.available,
                destination = "Destinação massa",
                anualRentability = BigDecimal(0.13),
                minimalMonths = 4,
                administrativeTaxes = BigDecimal(0.01)
            )
        )
        return "redirect:/products"
    }

}
