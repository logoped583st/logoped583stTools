package com.logopedbitbucket.login.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.logopedbitbucket.login.ui.AuthFragment

object Screens {

    fun authorizationScreen() = FragmentScreen {
        AuthFragment.getInstance()
    }

}