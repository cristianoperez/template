import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVersion = "1.3.31"

    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
    }
}

plugins {
    kotlin("jvm") version "1.3.31"
    id("io.gitlab.arturbosch.detekt") version "1.0.0.RC8"
}

group = "br.com.creditas"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

val compileKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions.jvmTarget = "1.8"
    doLast { println("Finished compiling Kotlin source code") }
}

val compileTestKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions.jvmTarget = "1.8"
    doLast { println("Finished compiling Kotlin source code for testing") }
}

detekt {
    version = "1.0.0.RC8"
    defaultProfile {
        input = "./"
        config = "./detekt-config.yml"
    }
}
