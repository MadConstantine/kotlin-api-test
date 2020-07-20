package com.constantine.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class RegisterResponse(
        @JsonProperty("id")
        val id: Int,
        @JsonProperty("token")
        val token: String
)