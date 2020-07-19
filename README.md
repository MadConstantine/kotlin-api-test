# kotlin-api-test
Test framework for http api tests. As AUT was chosen 'https://reqres.in/' testing REST api.
Implemented using Gradle, Kotlin, Retrofit 2 and Allure.
One can run gradle commands 'clean' and 'test' to clean run tests and 'allureReport' and 'allureServe' to make report and explore it.
Also base url of tested host can be set from 'BASE_URL' environment variable.
