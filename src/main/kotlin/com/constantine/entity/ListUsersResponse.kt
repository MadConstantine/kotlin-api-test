package com.constantine.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

data class ListUsersResponse(
        @JsonProperty("page")
        val page: Int,
        @JsonProperty("per_page")
        val perPage: Int,
        @JsonProperty("total")
        val total: Int,
        @JsonProperty("total_pages")
        val totalPages: Int,
        @JsonProperty("data")
        val data: List<User>,
        @JsonProperty("ad")
        val ad: Map<String, String>
)