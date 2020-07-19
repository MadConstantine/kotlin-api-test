package com.constantine.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class User(
        @JsonProperty("id")
        val id: String,
        @JsonProperty("email")
        val email: String,
        @JsonProperty("first_name")
        val firstName: String,
        @JsonProperty("last_name")
        val lastName: String,
        @JsonProperty("avatar")
        val avatarLink: String
)