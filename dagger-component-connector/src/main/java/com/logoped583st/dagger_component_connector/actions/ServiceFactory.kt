package com.logoped583st.dagger_component_connector.actions

interface ServiceFactory {
    fun <S> createService(baseUrl: String, service: Class<S>): S
}