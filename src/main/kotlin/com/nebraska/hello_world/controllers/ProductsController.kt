package com.nebraska.hello_world.controllers

import com.nebraska.hello_world.entities.InvestmentProduct
import com.nebraska.hello_world.repositories.ProductsRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/products")
class ProductsController(
    val repository: ProductsRepository
) {

    @GetMapping(value = ["/", ""])
    fun index(model: Model): String {
        model.addAttribute(
            "products", listOf(
                InvestmentProduct(name = "Produto A"),
                InvestmentProduct(name = "Produto B"),
                InvestmentProduct(name = "Produto C")
            )
        )
        return "products/products_list"
    }

    @GetMapping("/empty")
    fun empty(model: Model): String {
        model.addAttribute("products", listOf<InvestmentProduct>())
        return "products/layout"
    }

}
