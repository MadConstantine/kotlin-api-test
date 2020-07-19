package com.constantine.step

import com.constantine.api.ReqresApiInterface
import com.constantine.entity.ListUsersResponse
import com.constantine.executor.AbstractRequestExecutor
import io.qameta.allure.Step
import retrofit2.Response

class ReqresSteps (baseUrl: String): AbstractRequestExecutor<ReqresApiInterface>(baseUrl) {

    private val reqresApi = getApi(ReqresApiInterface::class.java)

    @Step("Get list of users request")
    fun listUsers(page: Int?, perPage: Int?): Response<ListUsersResponse> {
        return reqresApi.listUsers(page, perPage).execute()
    }
}