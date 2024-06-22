
val kotlin_version: String by project
val logback_version: String by project
val postgres_version: String by project
val h2_version: String by project

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("io.ktor.plugin") version "2.3.11"

}

group = "com.example"
version = "0.0.1"


application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    //Ktor
    testImplementation("io.ktor:ktor-server-tests-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-config-yaml")
    implementation ("io.ktor:ktor-server-netty:2.0.0")
    implementation ("io.ktor:ktor-serialization-jackson:2.0.0")
    implementation ("io.ktor:ktor-server-core:2.0.0")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    //Postgres
    implementation ("org.postgresql:postgresql:42.3.1")
    implementation("org.postgresql:postgresql:$postgres_version")
    //Database
    implementation("com.h2database:h2:$h2_version")
    //Logback
    implementation("ch.qos.logback:logback-classic:$logback_version")
    //Kotlin
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

}
//Creation ktor-server.jar
tasks {
    jar {
        manifest {
            attributes(mapOf("Main-Class" to "com.example.ApplicationKt"))
        }
        archiveFileName.set("ktor-server.jar")
    }
}

