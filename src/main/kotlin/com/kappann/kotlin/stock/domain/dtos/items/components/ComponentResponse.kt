package com.kappann.kotlin.stock.domain.dtos.items.components

import java.math.BigDecimal

class ComponentResponse(
    var id: Long?,

    var name: String?,

    var description: String?,

    var manufacturingPrice: BigDecimal?
)
