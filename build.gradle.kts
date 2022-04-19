import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

group = "me.bruno"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.oracle.database.jdbc:ojdbc8:21.5.0.0")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.github.jparsec:jparsec-g:1.0")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.20")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}