package com.constantine.executor

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

abstract class AbstractRequestExecutor<T>(private val baseUrl: String) {

    fun getApi(clazz: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
        return retrofit.create(clazz)
    }
}