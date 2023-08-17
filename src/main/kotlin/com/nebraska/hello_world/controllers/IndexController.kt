package com.nebraska.hello_world.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@RequestMapping("/")
class IndexController {
    @GetMapping("")
    fun index(): String {
        return "redirect:/products/"
    }
}

@RestController
@RequestMapping("/status")
class StatusController {
    @GetMapping(value = ["/", ""])
    fun status(): Unit {}
}