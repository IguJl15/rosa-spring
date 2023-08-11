package com.nebraska.hello_world.repositories

import com.nebraska.hello_world.entities.InvestmentProduct
import org.springframework.data.repository.ListCrudRepository

@org.springframework.stereotype.Repository
interface ProductsRepository : ListCrudRepository<InvestmentProduct, Long?>