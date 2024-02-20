package com.kappann.kotlin.stock.domain.models

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Entity(name = "Item")
class ItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field: NotEmpty(message = "Item name must be provided!")
    var name: String? = null,

    var description: String? = null,

    @field: NotNull(message = "Cost of manufacturing must be provided!")
    var manufacturingPrice: BigDecimal? = null,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentItem")
    var components: MutableList<ItemComponentEntity>? = null
)
