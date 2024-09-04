plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    // Apply the Shadow plugin to create a fat JAR (all dependencies in one JAR).
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("dev.hydraulic.conveyor") version "1.4"
}

version = "1.2"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // This dependency is used by the application.
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    // Define the main class for the application.
    mainClass.set("raytracer2d.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

// Task to create a fat JAR (JAR with all dependencies included).
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("raytracer2d")
    archiveClassifier.set("")
    archiveVersion.set("")
    mergeServiceFiles()
}

tasks.register<Exec>("packageExe") {
    dependsOn(tasks.named("jar"))
    group = "distribution"

    commandLine(
        "conveyor --cache-dir=\"Y\\Hydraulic\\Cache\" --data-dir=\"Y\\Hydraulic\\Data\" --logs-dir=\"Y\\Hydraulic\\Logs\" make site ; (cd output; npx serve .)"
    )
}