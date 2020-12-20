import Build_gradle.GradleBuild.build_gradle
import Build_gradle.GradleBuild.kotlin_gradle_plugin

plugins {
    `kotlin-dsl`
}

object GradleBuild {
    private const val kotlin_version = "1.4.21"
    private const val build_gradle_version = "4.1.1"

    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    const val build_gradle = "com.android.tools.build:gradle:$build_gradle_version"
}

dependencies {
    implementation(kotlin_gradle_plugin)
    implementation(build_gradle)
}

repositories {
    jcenter()
    google()
}

//remove when it will be fixed https://youtrack.jetbrains.com/issue/KT-41142
configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    }
}

gradlePlugin {
    plugins {
        create("AndroidGradlePlugin") {
            id = "AndroidGradlePlugin"
            implementationClass = "com.logoped583st.buildsrc.AndroidGradlePlugin"
        }
    }
}
