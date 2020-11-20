package com.testing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class UtilTest : StringSpec() {

    init {
        "should do complicated things and return true" {
            val util = Util()

            val result = util.doComplicatedThings(2)

            result shouldBe true
        }

        "should do complicated things and return false if number < 2" {
            val util = Util()

            val result = util.doComplicatedThings(-1)

            result shouldBe false
        }

        "should do complicated things and return false" {
            val util = Util()

            val result = util.doComplicatedThings(4)

            result shouldBe false
        }
    }
}