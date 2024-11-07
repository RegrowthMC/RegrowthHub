plugins {
    java
    `maven-publish`
    id("io.github.goooler.shadow") version("8.1.7")
}

group = "org.lushplugins"
version = "1.0.0"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Spigot
    maven("https://repo.lushplugins.org/releases/") // LushLib
    maven("https://repo.lushplugins.org/snapshots/") // LushLib
    maven("https://repo.helpch.at/releases/") // PlaceholderAPI
    maven("https://jitpack.io/") // GMusic
}

dependencies {
    // Dependencies
    compileOnly("org.spigotmc:spigot-api:1.21.3-R0.1-SNAPSHOT")

    // Soft Dependencies
    compileOnly("com.github.Gecolay.GMusic:GMusic:ceb42cdd2f")
    compileOnly("me.clip:placeholderapi:2.11.5")

    // Libraries
    implementation("org.lushplugins:LushLib:0.8.3")
}

tasks {

    shadowJar {
        relocate("org.bstats", "org.lushplugins.lushrewards.libraries.bstats")
        relocate("org.lushplugins.lushlib", "org.lushplugins.lushrewards.libraries.lushlib")

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