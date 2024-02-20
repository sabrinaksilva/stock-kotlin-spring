package com.kappann.kotlin.stock.domain.dtos.items.compositions

import com.kappann.kotlin.stock.domain.models.ItemComponentEntity
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

class ItemCompositionRequest(
    @field: NotEmpty(message = "Item name must be provided!")
    var name: String? = null,

    var description: String? = null,

    @field: NotNull(message = "Cost of manufacturing must be provided!")
    var manufacturingPrice: BigDecimal? = null,

    var components: MutableList<ItemComponentEntity>? = null
)