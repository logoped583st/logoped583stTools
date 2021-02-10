package com.bitbucket.main_screen.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
object MainActivityRouterModule {

    private val cicerone = Cicerone.create()

    @Provides
    fun provideRouter(): Router = cicerone.router

    @Provides
    fun provideHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

}