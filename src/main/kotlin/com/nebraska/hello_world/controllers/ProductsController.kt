package com.nebraska.hello_world.controllers

import com.nebraska.hello_world.entities.InvestmentProduct
import com.nebraska.hello_world.repositories.ProductsRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


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
        // TODO: turn properties into variables to clean up code
        repository.save(
            newProduct.copy(
                anualRentability = newProduct.anualRentability / 100,
                administrativeTaxes = newProduct.administrativeTaxes / 100
            )
        )

        return "redirect:/products/"
    }
}
