package com.constantine.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class AlterUserResponse(
        @JsonProperty("name")
        val name: String,
        @JsonProperty("job")
        val job: String,
        @JsonProperty("updatedAt")
        val updatedAt: String
)