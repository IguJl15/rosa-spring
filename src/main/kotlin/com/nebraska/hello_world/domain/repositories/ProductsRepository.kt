package com.nebraska.hello_world.domain.repositories

import com.nebraska.hello_world.domain.entities.InvestmentProduct
import org.springframework.data.repository.ListCrudRepository

@org.springframework.stereotype.Repository
interface ProductsRepository : ListCrudRepository<InvestmentProduct, Long?>