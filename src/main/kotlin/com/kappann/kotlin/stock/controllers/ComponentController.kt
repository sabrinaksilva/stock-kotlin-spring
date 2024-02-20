package com.kappann.kotlin.stock.controllers

import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentRequest
import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentResponse
import com.kappann.kotlin.stock.services.ItemComponentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/items/components")
class ComponentController(private val componentService: ItemComponentService) {

    @PostMapping
    fun createComponent(@RequestBody componentRequest: ComponentRequest): ResponseEntity<ComponentResponse> {
        return ResponseEntity.ok(componentService.createComponent(componentRequest))
    }

}