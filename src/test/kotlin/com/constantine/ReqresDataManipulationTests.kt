package com.constantine

import io.qameta.allure.Description
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReqresDataManipulationTests: BaseTest() {

    @Test
    @DisplayName("Put user test")
    @Description("PUT http request to update user data")
    fun putUserTest() {
        val userId = 2
        val userName = "morpheus"
        val userJob = "zion resident"
        val response = reqresSteps.putUserRequest(userId, userName, userJob)
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertEquals(userName, response.body()?.name, "Name from response doesn't match initial name")
        assertEquals(userJob, response.body()?.job, "Job from response doesn't match initial job")
        assertNotNull(response.body()?.updatedAt, "Updated at field is null")
    }

    @Test
    @DisplayName("Patch user test")
    @Description("PATCH http request to update user data")
    fun patchUserTest() {
        val userId = 2
        val userName = "morpheus"
        val userJob = "zion resident"
        val response = reqresSteps.patchUserRequest(userId, userName, userJob)
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertEquals(userName, response.body()?.name, "Name from response doesn't match initial name")
        assertEquals(userJob, response.body()?.job, "Job from response doesn't match initial job")
        assertNotNull(response.body()?.updatedAt, "Updated at field is null")
    }

    @Test
    @DisplayName("Delete user test")
    @Description("DELETE http request to delete user")
    fun deleteUserTest() {
        val userId = 2
        val response = reqresSteps.deleteUserRequest(userId)
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertEquals(204, response.code(), "Response code wasn't as expected")
    }
}