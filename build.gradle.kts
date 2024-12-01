plugins {
    java
    `maven-publish`
    id("io.github.goooler.shadow") version("8.1.7")
}

group = "org.lushplugins"
version = "1.1.1"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Spigot
    maven("https://repo.lushplugins.org/snapshots/") // LushLib
}

dependencies {
    // Dependencies
    compileOnly("org.spigotmc:spigot-api:1.21.3-R0.1-SNAPSHOT")

    // Soft Dependencies

    // Libraries
    implementation("org.lushplugins:LushLib:0.10.19")
}

tasks {

    shadowJar {
        relocate("org.lushplugins.lushlib", "org.lushplugins.regrowthhub.libraries.lushlib")

        minimize()

        archiveFileName.set("${project.name}-${project.version}.jar")
    }

    processResources{
        expand(project.properties)

        inputs.property("version", rootProject.version)
        filesMatching("plugin.yml") {
            expand("version" to rootProject.version)
        }
    }
}

allprojects {
    apply(plugin = "java")

    group = rootProject.group
    version = rootProject.version

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    tasks {
        withType<JavaCompile> {
            options.encoding = "UTF-8"
        }
    }
}