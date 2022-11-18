import org.jetbrains.kotlin.com.intellij.openapi.vfs.StandardFileSystems.jar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.maximde"
version = "0.0.2"

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("RandomMOTD.jar")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        content {
            includeGroup ("org.bukkit")
            includeGroup ("org.spigotmc")
        }
    }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/central") }
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly ("org.spigotmc:spigot-api:1.19-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}