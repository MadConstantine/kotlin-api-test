package com.constantine

import io.qameta.allure.Description
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ReqresGetTests: BaseTest() {

    @Test
    @DisplayName("List users test")
    @Description("GET http request for list with users")
    fun listUsersTest() {
        val firstPage = 1
        val itemsPerPage = 6
        val firstItemIndex = 0
        val response = reqresSteps.listUsers(firstPage, itemsPerPage)
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertEquals(itemsPerPage, response.body()?.data?.size, "User's list size isn't as expected")
        assertNotNull(response.body()?.data?.get(firstItemIndex), "User's schema doesn't match")
        assertEquals("george.bluth@reqres.in", response.body()?.data?.get(firstItemIndex)?.email,
                "First user's email isn't as expected")
    }

    @Test
    @DisplayName("Get single user test")
    @Description("GET http request for single particular user by id")
    fun getUserTest() {
        val firstUserId = 1
        val response = reqresSteps.getUser(firstUserId)
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertNotNull(response.body()?.data, "User wasn't returned")

        val user = response.body()?.data
        assertEquals(firstUserId, user?.id, "User id doesn't match")
        assertEquals("george.bluth@reqres.in", user?.email, "User's email doesn't match")
        assertEquals("George", user?.firstName, "User's first name doesn't match")
        assertEquals("Bluth", user?.lastName, "User's las name doesn't match")
    }

    @Test
    @DisplayName("Get single user negative test")
    @Description("GET http request for single particular user with 404")
    fun notFoundUserTest() {
        val notExistentUserId = 23
        val response = reqresSteps.getUser(notExistentUserId)
        assertEquals(404, response.code(), "Code was not '404'")
        assertFalse(response.isSuccessful, "Request was successful")
        assertNull(response.body()?.data, "User was returned")
    }

    @Test
    @DisplayName("List resources test")
    @Description("GET http request for list with resources")
    fun listResourcesTest() {
        val firstPage = 1
        val itemsPerPage = 6
        val firstItemIndex = 0
        val response = reqresSteps.listResources(firstPage, itemsPerPage)
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertEquals(itemsPerPage, response.body()?.data?.size, "Resource's list size isn't as expected")
        assertNotNull(response.body()?.data?.get(firstItemIndex), "Resource's schema doesn't match")
        assertEquals("cerulean", response.body()?.data?.get(firstItemIndex)?.name,
                "First resource's name isn't as expected")
    }

    @Test
    @DisplayName("Get single resource test")
    @Description("GET http request for single particular user by id")
    fun getResourceTest() {
        val firstResourceId = 1
        val response = reqresSteps.getResource(firstResourceId)
        assertTrue(response.isSuccessful, "Request wasn't successful")
        assertNotNull(response.body()?.data, "Resource wasn't returned")

        val user = response.body()?.data
        assertEquals(firstResourceId, user?.id, "Resource id doesn't match")
        assertEquals("cerulean", user?.name, "Resource's name doesn't match")
        assertEquals(2000, user?.year, "Resource's year doesn't match")
        assertEquals("#98B2D1", user?.color, "Resource's color doesn't match")
        assertEquals("15-4020", user?.pantoneValue, "Resource's pantone_value doesn't match")
    }

    @Test
    @DisplayName("Get single resource negative test")
    @Description("GET http request for single particular resource with 404")
    fun notFoundResourceTest() {
        val notExistentUserId = 23
        val response = reqresSteps.getUser(notExistentUserId)
        assertEquals(404, response.code(), "Code was not '404'")
        assertFalse(response.isSuccessful, "Request was successful")
        assertNull(response.body()?.data, "Resource was returned")
    }
}
