package com.nebraska.hello_world.controllers

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController
import org.springframework.ui.Model
import org.springframework.beans.factory.annotation.Autowired
import java.util.Date;
import com.nebraska.hello_world.repositories.StockRepository



@Controller
@RequestMapping("/stocks")
public class StocksController(
    val repository: StockRepository) {
    
    @GetMapping(value= ["/", ""])
    fun index(model: Model): String {
        model.addAttribute("data", StocksControllerContext("Nome da pessoa e tal"));
        return "index";
    }

}

data class StocksControllerContext(val name: String)