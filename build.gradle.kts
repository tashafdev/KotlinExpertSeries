plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {


    // ✅ Main coroutine support
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // ✅ Kotlin Test (main assertions)
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.0")

    // ✅ JUnit 4 base (needed by kotlin-test-junit)
    testImplementation("junit:junit:4.13.2")

    // ✅ Coroutines test support
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    // ✅ MockK for mocking
    testImplementation("io.mockk:mockk:1.13.8")
    implementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.1.10")

}

tasks.test {
    useJUnit()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

kotlin {
    jvmToolchain(22)
}
