package com.kappann.kotlin.stock.services

import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentRequest
import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentResponse

interface ItemComponentService {
    fun createComponent(component: ComponentRequest): ComponentResponse
}