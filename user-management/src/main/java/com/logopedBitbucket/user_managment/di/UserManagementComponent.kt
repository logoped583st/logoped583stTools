package com.logopedBitbucket.user_managment.di

import com.logoped583st.dagger_component_connector.di.AndroidToolsProvider
import com.logoped583st.dagger_component_connector.di.EncryptionProvider
import dagger.Component

@Component(
        dependencies = [EncryptionProvider::class, AndroidToolsProvider::class]
)
interface UserManagementComponent {

}