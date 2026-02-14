plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id ("maven-publish")
    jacoco
    alias(libs.plugins.compose.compiler)
}

jacoco {
    toolVersion = "0.8.12"
}
apply(from = "${project.rootDir}/jacoco.gradle.kts")

val libVersion: String by project

android {
    namespace = "com.dude.keyboardlibrary"
    compileSdk = 36

    defaultConfig {
        minSdk=33
        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }
        getByName("release") {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kapt {
        correctErrorTypes = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes.add("META-INF/INDEX.LIST")
            excludes.add("META-INF/DEPENDENCIES")
            excludes.add("META-INF/LICENSE.md")
            excludes.add("META-INF/LICENSE-notice.md")
            pickFirsts  += "META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {
    //compose ui
    implementation(libs.androidx.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.tooling.preview)
    testImplementation(libs.junit.jupiter)
    debugImplementation(libs.androidx.tooling)
    debugImplementation(libs.androidx.test.manifest)
    debugImplementation (libs.androidx.core)
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    // Test rules and transitive dependencies
    androidTestImplementation(libs.androidx.test.junit4)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("library") {
            groupId = "dude.keyboard"
            artifactId = project.name
            version = libVersion
            artifact("${layout.buildDirectory.get()}/outputs/aar/${project.name}-release.aar")
            pom {
                withXml {
                    val dependenciesNode = asNode().appendNode("dependencies")
                    configurations.implementation.get().incoming.dependencies.forEach {
                        if (it.group != null && it.version != null) {
                            val dependencyNode = dependenciesNode.appendNode("dependency")
                            dependencyNode.appendNode("groupId", it.group)
                            dependencyNode.appendNode("artifactId", it.name)
                            dependencyNode.appendNode("version", it.version)
                        }
                    }
                }
            }
        }
    }
}