// Api test project
plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    id("io.qameta.allure") version "2.8.1"
}

val allureVersion = "2.8.1"
val junitVersion = "5.5.2"
val retrofitVersion = "2.6.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-jackson:$retrofitVersion")

    implementation("org.aspectj:aspectjweaver:1.8.10")
    implementation("io.qameta.allure:allure-junit5:$allureVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    implementation("org.slf4j:slf4j-simple:1.7.30")
}

allure {
    version = allureVersion
    autoconfigure = true
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    System.getenv()["BASE_URL"]?.let { systemProperty("BASE_URL", it) }
}
