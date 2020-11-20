package com.testing

class Service(private val util: Util) {

    fun someServiceMethod(number: Int): Boolean {
        if (util.doComplicatedThings(number)) {
            throw Exception("Cannot do this on complicated numbers")
        }
        if (number == 13) {
            throw Exception("Cannot do this on 13 numbers because it brings bad luck")
        }
        if (number == 17) {
            return false
        }
        return true
    }

    fun someOtherServiceMethod(number: Int): Boolean {
        if (number == 5) {
            return true
        }
        return false
    }
}