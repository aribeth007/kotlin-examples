package com.testing

class Util {

    fun doComplicatedThings(number: Int): Boolean {
        if(number<2) return false
        for (i in 2..number/2) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}