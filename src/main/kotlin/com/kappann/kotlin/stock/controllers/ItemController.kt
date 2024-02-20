package com.kappann.kotlin.stock.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/items")
class ItemController {

    @GetMapping
    fun helloWorld(): String = "Hello World!"

}