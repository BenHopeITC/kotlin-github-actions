import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotestVersion: String by project

plugins {
    kotlin("jvm") version "1.7.10"
    application

//    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    jacoco
    id("org.sonarqube") version "3.4.0.2513"

    id("com.diffplug.spotless") version "6.22.0"
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

val installLocalGitHook =
    task(name = "installLocalGitHook", type = Copy::class) {
        from(File(rootProject.rootDir, "scripts/pre-commit"))
        into(File(rootProject.rootDir, ".git/hooks"))
        fileMode = 0b111101101
    }

tasks.build {
    dependsOn(installLocalGitHook)
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        // by default the target is every '.kt' and '.kts` file in the java sourcesets
        ktfmt() // has its own section below
        ktlint() // has its own section below
//        diktat()   // has its own section below
//        prettier() // has its own section below
//        licenseHeader "/* (C)$YEAR */" // or licenseHeaderFile
    }
    kotlinGradle {
//        target "*.gradle.kts" // default target for kotlinGradle
        ktlint() // or ktfmt() or prettier()
    }
}

// kover {
//    isDisabled.set(false) // true to disable instrumentation and all Kover tasks in this project
//    engine.set(kotlinx.kover.api.DefaultIntellijEngine)
// }

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        enabled

        xml.required.set(true)

        csv.required.set(false)

        html.required.set(false)
//        html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
    }
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    val excludeSlowTests = System.getProperty("excludeSlowTests")?.isNotEmpty() ?: false

    val excludeList = mutableSetOf<String>()

    if (excludeSlowTests) excludeList.add("slow")

    if (excludeList.isNotEmpty()) {
        useJUnitPlatform {
            excludeTags = excludeList
        }
    } else {
        useJUnitPlatform()
    }

    finalizedBy(tasks.jacocoTestReport)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    testLogging {
        events("passed", "skipped", "failed")
    }
}
