package com.kappann.kotlin.stock.domain.models

import jakarta.persistence.*

@Entity(name = "ItemComponent")
class ItemComponentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_item_id")
    var parentItem: ItemEntity,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "component_item_id")
    var component: ItemEntity,

    var requiredQuantity: Int
)