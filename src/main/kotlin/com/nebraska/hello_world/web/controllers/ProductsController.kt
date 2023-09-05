package com.nebraska.hello_world.web.controllers

import com.nebraska.hello_world.domain.dtos.CreateProductDto
import com.nebraska.hello_world.domain.entities.InvestmentProduct
import com.nebraska.hello_world.domain.services.InvestmentProductsService
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/products")
class ProductsController(
    private val service: InvestmentProductsService,
) {

    @GetMapping("/teste/{id}")
    fun teste(@PathVariable("id") @Min(5) id: Int): String {

        return "redirect:/products/"
    }

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

        // TODO: turn properties into variables to clean up code
        service.createProduct(createProductDto.apply {
            anualRentability /= 100
            administrativeTaxes /= 100
        })

        return "redirect:/products/"
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun handleValidationExceptions(ex: MethodArgumentNotValidException): Map<String, String?> {
//        val errors: MutableMap<String, String?> = HashMap()
//        ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
//            val fieldName = (error as FieldError).field
//            val errorMessage = error.getDefaultMessage()
//            errors[fieldName] = errorMessage
//        })
//
//        return errors
//    }
}
