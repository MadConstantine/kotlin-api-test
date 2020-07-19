package com.constantine.api

import com.constantine.entity.*
import retrofit2.Call
import retrofit2.http.*

interface ReqresApiInterface {
    @GET("/api/users")
    fun listUsers(
            @Query("page") page: Int?,
            @Query("per_page") perPage: Int?
    ): Call<ReqresResponse<List<User>>>

    @GET("/api/users/{userId}")
    fun getUser(
            @Path("userId") userId: Int
    ): Call<ReqresResponse<User>>

    @PATCH("/api/users/{userId}")
    fun patchUser(
            @Path("userId") userId: Int,
            @Body registerBody: Map<String, String?>
    ): Call<AlterUserResponse>

    @PUT("/api/users/{userId}")
    fun putUser(
            @Path("userId") userId: Int,
            @Body registerBody: Map<String, String?>
    ): Call<AlterUserResponse>

    @DELETE("/api/users/{userId}")
    fun deleteUser(
            @Path("userId") userId: Int
    ): Call<Unit>

    @GET("/api/unknown")
    fun listResources(
            @Query("page") page: Int?,
            @Query("per_page") perPage: Int?
    ): Call<ReqresResponse<List<Resource>>>

    @GET("/api/unknown/{resourceId}")
    fun getResource(
            @Path("resourceId") resourceId: Int
    ): Call<ReqresResponse<Resource>>

    @POST("/api/register")
    fun register(
            @Body registerBody: Map<String, String?>
    ): Call<RegisterResponse>
}