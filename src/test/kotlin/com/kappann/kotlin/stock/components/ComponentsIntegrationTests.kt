package com.kappann.kotlin.stock.components

import com.kappann.kotlin.stock.StockApplication
import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentRequest
import com.kappann.kotlin.stock.domain.dtos.items.components.ComponentResponse
import com.kappann.kotlin.stock.errors.handlers.ErrorResponse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import java.math.BigDecimal

@SpringBootTest(
    classes = [StockApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ComponentsIntegrationTests(@Autowired var restTemplate: TestRestTemplate) {

    @Test
    fun shouldCreateItemWithoutSubComponents() {
        val nameRequest = "nametestwithoutsubitems"
        val descriptionRequest = "some description"
        val manufacturingPriceRequest = BigDecimal.TEN

        val componentRequest = ComponentRequest(
            name = nameRequest,
            description = descriptionRequest,
            manufacturingPrice = manufacturingPriceRequest
        )


        val result =
            this.restTemplate.postForEntity("/api/v1/items/components", componentRequest, ComponentResponse::class.java)

        assertNotNull(result.body?.id)
        assertTrue { result.body?.name.equals(nameRequest) }
        assertTrue { result.body?.description.equals(descriptionRequest) }
        assertNotNull(result.body?.manufacturingPrice)
        assertTrue { manufacturingPriceRequest.equals(result.body?.manufacturingPrice) }

    }


    @Test
    fun shouldNotCreateItemWithMissingFieldsAndMustThrowException() {
        val nameRequest = null
        val descriptionRequest = "some description"
        val manufacturingPriceRequest = null

        val componentRequest = ComponentRequest(
            name = nameRequest,
            description = descriptionRequest,
            manufacturingPrice = manufacturingPriceRequest
        )

        val result =
            this.restTemplate.postForEntity("/api/v1/items/components", componentRequest, ErrorResponse::class.java)

        val expectedResult = "Error(s): /nItem name must be provided! /nCost of manufacturing must be provided! /n"
        val anotherValidExpectedResult =
            "Error(s): /nCost of manufacturing must be provided! /nItem name must be provided! /n"
        assertNotNull(
            result.body?.message
        )

        assertTrue {
            result.body?.message.equals(expectedResult) || result.body?.message.equals(
                anotherValidExpectedResult
            )
        }


    }
}