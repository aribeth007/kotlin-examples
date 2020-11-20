package com.testing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class ControllerTest : StringSpec() {

    init {
        "Controller should say YES because every service call returns true" {
            val service = mockk<Service>()
            val controller = Controller(service)
            every { service.someServiceMethod(any()) } returns true
            every { service.someOtherServiceMethod(any()) } returns true

            val result = controller.someControllerMethod(2, 5)

            result shouldBe "YES!"
        }

        "Controller should say NO because one service call returns false" {
            val service = mockk<Service>()
            val controller = Controller(service)
            every { service.someServiceMethod(any()) } returns false
            every { service.someOtherServiceMethod(any()) } returns true

            val result = controller.someControllerMethod(4, 5)

            result shouldBe "NO!"
        }

        "Controller should say NO because other service call returns false" {
            val service = mockk<Service>()
            val controller = Controller(service)
            every { service.someServiceMethod(any()) } returns true
            every { service.someOtherServiceMethod(any()) } returns false

            val result = controller.someControllerMethod(3, 1)

            result shouldBe "NO!"
        }

        "Test that could replace all of the above" {
            val service = mockk<Service>()
            val controller = Controller(service)

            forAll(
                row(true, true, "YES!"),
                row(false, true, "NO!"),
                row(true, false, "NO!")
            ) { firstServiceResult, secondServiceResult, expectedResult ->
                every { service.someServiceMethod(any()) } returns firstServiceResult
                every { service.someOtherServiceMethod(any()) } returns secondServiceResult

                val result = controller.someControllerMethod(3, 1)

                expectedResult shouldBe result
            }
        }

        "Controller should throw exception if one of the service calls throws exception" {
            val service = mockk<Service>()
            val controller = Controller(service)
            every { service.someServiceMethod(any()) } throws Exception("NOOO!")
            every { service.someOtherServiceMethod(any()) } returns false

            shouldThrow<Exception> {
                controller.someControllerMethod(3, 1)
            }
        }
    }
}