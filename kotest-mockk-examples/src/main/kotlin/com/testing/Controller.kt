package com.testing

class Controller(private val service: Service) {
    fun someControllerMethod(firstNumber: Int, secondNumber: Int): String {
        val check1 = service.someServiceMethod(firstNumber)
        val check2 = service.someOtherServiceMethod(secondNumber)
        if (check1 && check2) {
            return "YES!"
        }
        return "NO!"
    }
}