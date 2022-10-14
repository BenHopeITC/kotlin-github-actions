import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotestVersion: String by project

plugins {
    kotlin("jvm") version "1.7.10"
    application

    id("org.jetbrains.kotlinx.kover") version "0.6.1"

    id("org.sonarqube") version "3.4.0.2513"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

kover {
    isDisabled.set(false) // true to disable instrumentation and all Kover tasks in this project
    engine.set(kotlinx.kover.api.DefaultIntellijEngine)
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed")
    }
}
