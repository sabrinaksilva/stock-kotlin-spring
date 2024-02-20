package com.kappann.kotlin.stock.services

import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentRequest

interface ItemComponentService {
    fun createComponent(component: ComponentRequest): Long
}