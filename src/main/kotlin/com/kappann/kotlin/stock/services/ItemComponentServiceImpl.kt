package com.kappann.kotlin.stock.services

import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentRequest
import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentResponse
import com.kappann.kotlin.stock.domain.models.ItemEntity
import com.kappann.kotlin.stock.repositories.StockItemRepository
import org.springframework.stereotype.Service

@Service
class ItemComponentServiceImpl(val itemRepository: StockItemRepository) : ItemComponentService {


    override fun createComponent(component: ComponentRequest): ComponentResponse {
        var itemComponentEntity = ItemEntity(
            name = component.name,
            description = component.description,
            manufacturingPrice = component.manufacturingPrice,
            components = arrayListOf()
        )

        itemComponentEntity = itemRepository.save(itemComponentEntity)

        return ComponentResponse(
            id = itemComponentEntity.id,
            name = itemComponentEntity.name,
            description = itemComponentEntity.description,
            manufacturingPrice = itemComponentEntity.manufacturingPrice
        )

    }
}