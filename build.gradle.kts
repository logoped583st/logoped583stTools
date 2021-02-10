allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://oss.jfrog.org/libs-snapshot") }
        maven { url = uri("https://dl.bintray.com/kirich1409/maven") }
    }
}
