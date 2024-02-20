package com.kappann.kotlin.stock.domain.dtos.items.components

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

class ComponentRequest(
    @field: NotEmpty(message = "Item name must be provided!")
    var name: String? = null,

    var description: String?,

    @field: NotNull(message = "Cost of manufacturing must be provided!")
    var manufacturingPrice: BigDecimal? = null
)