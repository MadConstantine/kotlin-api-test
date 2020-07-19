package com.constantine

import com.constantine.step.ReqresSteps

abstract class BaseTest {
    protected companion object {
        val reqresSteps = ReqresSteps(System.getenv("BASE_URL")?: "https://reqres.in/")
    }
}