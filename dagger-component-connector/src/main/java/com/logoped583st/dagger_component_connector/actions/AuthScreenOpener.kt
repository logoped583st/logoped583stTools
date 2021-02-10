package com.logoped583st.dagger_component_connector.actions

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun interface AuthScreenOpener {
    fun getScreen(): FragmentScreen
}