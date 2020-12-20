import com.logoped583st.buildsrc.libraries.*
import com.logoped583st.buildsrc.setupConfig

plugins {
    id("AndroidGradlePlugin")
    `kotlin-kapt`
}

android {
    setupConfig()
}

dependencies {
    ui()
    kotlin()
    ktx()
    dagger()
    rx()
    rxBinding()
    paging()
    unitTests()
}