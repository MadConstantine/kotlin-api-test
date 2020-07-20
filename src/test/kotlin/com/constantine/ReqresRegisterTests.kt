package com.constantine

import io.qameta.allure.Description
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReqresRegisterTests: BaseTest() {

    @Test
    @DisplayName("POST register test")
    @Description("POST http request with proper parameters")
    fun registerPositiveTest() {
        val response = reqresSteps.registerProperly("eve.holt@reqres.in", "pistol")
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertEquals(4, response.body()?.id, "Unexpected id was returned")
        assertEquals("QpwL5tke4Pnpja7X4", response.body()?.token, "Unexpected token was returned")
    }

    @Test
    @DisplayName("POST register negative test")
    @Description("POST http request with missing password parameter")
    fun registerNegativeTest() {
        val response = reqresSteps.registerFailure("sydney@fife")
        assertFalse(response.isSuccessful, "Request wasn't successful")
        assertEquals(400, response.code(), "Code was not '400'")
        assertEquals("Bad Request", response.message(), "Wrong response message")
        assertEquals("{\"error\":\"Missing password\"}", response.errorBody()?.string(),
                "Wrong response error message")
    }
}