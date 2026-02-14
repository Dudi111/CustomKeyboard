apply(plugin = "jacoco")

tasks.withType<Test> {
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}

project.afterEvaluate {
    createJacocoTestReport("jacocoTestReport")
}

//Use this method to generate the HTML and XML coverage report files for Unit and UI test cases
fun createJacocoTestReport(taskName: String) {
    val androidTestCoverageTask = "createDebugCoverageReport"
    val unitTestTask = "testDebugUnitTest"

    tasks.create(name = taskName, type = JacocoReport::class) {
        group = "Reporting"
        description = "Generate Jacoco coverage reports for the Debug build."

        reports {
            html.required.set(true)
            xml.required.set(true)
        }

        val excludes = listOf(
                "**/BuildConfig.*",
                "**/Manifest*.*",
                "**/*Test*.*",
                "android/**/*.*",
                "androidx/**/*.*",
                "**/*MembersInjector*.*",
                "**/*_Factory.*",
                "**/*_Provide*Factory*.*",
                "**/AutoValue_*.*",
                "**/R2.class",
                "**/R2$*.class",
                "**/*Directions$*",
                "**/KeyView*.*",//reason: not able to cover all condition because of compose function coverage is 71.4%
                "**/KeyboardView*.*",//reason: not able to cover all condition because of compose function coverage is 76.3%
                "**/KeyButton*.*",//reason: not able to cover all condition because of compose function coverage is 77.3%
                "**/NumericKeyboardView*.*",//reason: not able to cover all condition because of compose function coverage is 80.8%
                "**/AlphabetKeyboard*.*",//reason: not able to cover all condition because of compose function coverage is 85.2%
                "**/AlphanumericKeyboard*.*",//reason: not able to cover all condition because of compose function coverage is 85.7%
                "**/ChatKeyboardKey*.*",//reason: not able to cover all condition because of compose function coverage is 78.5%
                "**/ChatKeyboardKeyView*.*",//reason: not able to cover all condition because of compose function coverage is 73.1%
                "**/ChatKeyboard*.*",
                "**/KeyboardKey*.*",
                "**/KeyButtonLongClick*"
        )

        val kClasses ="${layout.buildDirectory.get()}/tmp/kotlin-classes/debug"
        val kotlinClasses = fileTree(mapOf("dir" to kClasses, "excludes" to excludes))
        classDirectories.setFrom(files(kotlinClasses))
        val sourceDirs = listOf("${project.projectDir}/src/main/java")
        sourceDirectories.setFrom(files(sourceDirs))
        val androidTestsData = fileTree(
            mapOf(
                "dir" to "${layout.buildDirectory.get()}/outputs/code_coverage/debugAndroidTest/connected/",
                "includes" to listOf("**/*.ec")
            )
        )
        executionData(
            files(
                listOf(
                    "${project.layout.buildDirectory.get()}/outputs/unit_test_code_coverage/debugUnitTest/testDebugUnitTest.exec",
                    androidTestsData
                )
            )
        )
        dependsOn(unitTestTask,androidTestCoverageTask)
    }
}