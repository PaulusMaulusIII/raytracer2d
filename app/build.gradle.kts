plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    // Apply the Shadow plugin to create a fat JAR (all dependencies in one JAR).
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

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

// Optional: You can use this task to ensure your project builds a JAR with all dependencies.
tasks.register<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("fatJar") {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
    from(sourceSets.main.get().output)
    configurations = listOf(project.configurations.runtimeClasspath.get())
    archiveBaseName.set("raytracer2d-all")
    archiveClassifier.set("")
    archiveVersion.set("")
    mergeServiceFiles()
}

// Use jpackage to create an executable from the fat JAR.
// Ensure you are using JDK 14 or higher as jpackage is part of the JDK.
tasks.register<Exec>("packageExe") {
    dependsOn(tasks.named("fatJar"))
    group = "distribution"
    description = "Package the application as an executable using jpackage"

    commandLine(
        "jpackage",
        "--input", "${buildDir}/libs",
        "--main-jar", "raytracer2d-all.jar",
        "--main-class", application.mainClass.get(),
        "--type", "exe",
        "--dest", "${buildDir}/dist",
        "--name", "RayTracer2D"
    )
}

