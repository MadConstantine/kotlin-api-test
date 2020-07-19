package com.constantine.step

import com.constantine.api.ReqresApiInterface
import com.constantine.entity.*
import com.constantine.executor.AbstractRequestExecutor
import io.qameta.allure.Step
import retrofit2.Response

class ReqresSteps (baseUrl: String): AbstractRequestExecutor<ReqresApiInterface>(baseUrl) {

    private val reqresApi = getApi(ReqresApiInterface::class.java)

    @Step("Get list of users request")
    fun listUsers(page: Int?, perPage: Int?): Response<ReqresResponse<List<User>>> {
        return reqresApi.listUsers(page, perPage).execute()
    }

    @Step("Get user #{userId} request")
    fun getUser(userId: Int): Response<ReqresResponse<User>> {
        return reqresApi.getUser(userId).execute()
    }

    @Step("Get list of resources request")
    fun listResources(page: Int?, perPage: Int?): Response<ReqresResponse<List<Resource>>> {
        return reqresApi.listResources(page, perPage).execute()
    }

    @Step("Get resource #{resourceId} request")
    fun getResource(resourceId: Int): Response<ReqresResponse<Resource>> {
        return reqresApi.getResource(resourceId).execute()
    }

    @Step("Do register POST request with email:{email} and password:{password}")
    fun registerProperly(email: String, password: String): Response<RegisterResponse> {
        val body = mapOf("email" to email, "password" to password)
        return reqresApi.register(body).execute()
    }

    @Step("Do register POST request with email:{email} only")
    fun registerFailure(email: String): Response<RegisterResponse> {
        val body = mapOf("email" to email)
        return reqresApi.register(body).execute()
    }

    @Step("Do PUT user:{userId} request with name:{name} and job:{job} parameters")
    fun putUserRequest(userId: Int, name: String, job: String): Response<AlterUserResponse> {
        val body = mapOf("name" to name, "job" to job)
        return reqresApi.putUser(userId, body).execute()
    }

    @Step("Do PATCH user:{userId} request with name:{name} and job:{job} parameters")
    fun patchUserRequest(userId: Int, name: String, job: String): Response<AlterUserResponse> {
        val body = mapOf("name" to name, "job" to job)
        return reqresApi.patchUser(userId, body).execute()
    }

    @Step("DELETE user:{userId} request")
    fun deleteUserRequest(userId: Int): Response<Unit> {
        return reqresApi.deleteUser(userId).execute()
    }
}