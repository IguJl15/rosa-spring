package com.nebraska.hello_world.web.controllers

import com.nebraska.hello_world.domain.dtos.CreateProductDto
import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.services.InvestmentProductsService
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/products")
class ProductsController(
    private val service: InvestmentProductsService,
) {
    @GetMapping(value = ["/", ""])
    fun index(model: Model): String {
        val products = service.findAllProducts()

        model.addAttribute("products", products)
        model.addAttribute("newProduct", InvestmentProduct())

        return "products/products_list"
    }

    @GetMapping("/new")
    fun newProductPage(model: Model): String {
        if (!model.containsAttribute("createProductDto")) {
            model["createProductDto"] = CreateProductDto()
        }

        return "products/new_product"
    }

    @PostMapping("/new")
    fun createNewProject(
        @Valid createProductDto: CreateProductDto, results: BindingResult, model: Model
    ): String {
        if (results.hasErrors()) {
            return "products/new_product"
        }

        service.createProduct(createProductDto)

        return "redirect:/products/"
    }
}
