import com.logoped583st.buildsrc.libraries.ui
import com.logoped583st.buildsrc.setupConfig

plugins {
    `android-library`
}

android {
    setupConfig()
}
dependencies {
    ui()
}
