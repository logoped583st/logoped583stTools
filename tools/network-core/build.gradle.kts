import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.gson
import com.logoped583st.buildsrc.libraries.kotlin
import com.logoped583st.buildsrc.libraries.network

plugins {
    kotlin
    `kotlin-kapt`
}


//kapt {
//    generateStubs = true
//    javacOptions {
//        option("-Xmaxerrs", 500)
//    }
//}

dependencies {
    kotlin()
    gson()
    network()
    dagger()
}