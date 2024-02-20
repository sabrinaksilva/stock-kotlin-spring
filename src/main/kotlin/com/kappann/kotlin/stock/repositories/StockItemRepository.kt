package com.kappann.kotlin.stock.repositories

import com.kappann.kotlin.stock.domain.models.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StockItemRepository : JpaRepository<ItemEntity, Long>