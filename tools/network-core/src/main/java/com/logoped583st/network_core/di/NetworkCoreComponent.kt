package com.logoped583st.network_core.di

import com.logoped583st.dagger_component_connector.di.Logger
import com.logoped583st.dagger_component_connector.di.LoggerProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [NetworkCoreModule::class]
)
interface NetworkCoreComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun tokenRetriever(retriever: Refresher): Builder
        @BindsInstance fun logger(logger: LoggerProvider): Builder
        fun build(): NetworkCoreComponent
    }
}
