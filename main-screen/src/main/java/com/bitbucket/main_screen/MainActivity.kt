package com.bitbucket.main_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitbucket.main_screen.di.initMainActivityComponent
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.logoped583st.dagger_component_connector.actions.AuthScreenOpener
import com.logoped583st.dagger_component_connector.component
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navi: AuthScreenOpener

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var holder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMainActivityComponent(
                application.component()
        ).inject(this)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            router.newRootScreen(navi.getScreen())
        }

    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        holder.setNavigator(AppNavigator(this, R.id.main_container))
    }

    override fun onPause() {
        super.onPause()
        holder.removeNavigator()
    }
}

