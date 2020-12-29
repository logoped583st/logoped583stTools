package com.logoped583st.android_tools.di

import android.content.Context
import com.logoped583st.dagger_component_connector.di.AndroidToolsProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PreferencesModule::class])
internal interface AndroidToolsComponent : AndroidToolsProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        @BindsInstance
        fun prefsName(name: String): Builder
        fun build(): AndroidToolsComponent
    }

}

fun initAndroidModule(context: Context, prefsName:String): AndroidToolsProvider {
    return DaggerAndroidToolsComponent
            .builder()
            .context(context)
            .prefsName(prefsName)
            .build()
}