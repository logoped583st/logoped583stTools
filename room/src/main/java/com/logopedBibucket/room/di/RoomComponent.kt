package com.logopedBibucket.room.di

import android.content.Context
import com.logoped583st.dagger_component_connector.di.EncryptionProvider
import com.logoped583st.dagger_component_connector.di.LoggerProvider
import dagger.BindsInstance
import dagger.Component
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

@Component(
        modules = [RoomModule::class],
        dependencies = [LoggerProvider::class, EncryptionProvider::class]
)
interface RoomComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): RoomComponent
    }
}

fun test(){

}