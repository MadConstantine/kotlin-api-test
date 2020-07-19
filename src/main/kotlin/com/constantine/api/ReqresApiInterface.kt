package com.constantine.api

import com.constantine.entity.ListUsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresApiInterface {
    @GET("/api/users")
    fun listUsers(
            @Query("page") page: Int?,
            @Query("per_page") perPage: Int?
    ): Call<ListUsersResponse>
}