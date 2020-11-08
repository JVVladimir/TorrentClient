plugins {
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.dampcake:bencode:1.3.1")
    implementation("io.github.microutils:kotlin-logging:2.0.3")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("commons-codec:commons-codec:1.15")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.assertj:assertj-core:3.18.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}

tasks.withType<Test> {
    useJUnitPlatform()
}