plugins {
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    jacoco
    alias(libs.plugins.sonarqube) apply false
    alias(libs.plugins.compose.compiler) apply false
}

buildscript {
    dependencies {
        classpath(libs.org.jacoco.ant)
    }
}
apply(from = "${project.rootDir}/sonar.gradle")
