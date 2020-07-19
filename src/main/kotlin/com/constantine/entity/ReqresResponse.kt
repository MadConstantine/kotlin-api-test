package com.constantine.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqresResponse<T>(
        @JsonProperty("page")
        val page: Int,
        @JsonProperty("per_page")
        val perPage: Int,
        @JsonProperty("total")
        val total: Int,
        @JsonProperty("total_pages")
        val totalPages: Int,
        @JsonProperty("data")
        val data: T,
        @JsonProperty("ad")
        val ad: Map<String, String>
)