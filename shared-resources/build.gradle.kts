import com.logoped583st.buildsrc.libraries.ui
import com.logoped583st.buildsrc.setupSdkVersions

plugins {
    `android-library`
}

android {
    setupSdkVersions()
}
dependencies {
    ui()
}
