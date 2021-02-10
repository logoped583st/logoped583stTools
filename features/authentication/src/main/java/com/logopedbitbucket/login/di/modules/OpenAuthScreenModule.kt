package com.logopedbitbucket.login.di.modules

import com.logoped583st.dagger_component_connector.actions.AuthScreenOpener
import com.logopedbitbucket.login.navigation.Screens
import dagger.Module
import dagger.Provides

@Module
object OpenAuthScreenModule {

    @Provides
    fun screenOpener(): AuthScreenOpener {
        return AuthScreenOpener {
            Screens.authorizationScreen()
        }
    }
}