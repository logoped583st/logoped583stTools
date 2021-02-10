package com.example.dagger_component_holder

abstract class ComponentHolder<C> {

    private var component: C? = null

    fun destroyComponent() {
        component = null
    }

    abstract fun initComponent(): C

    @Synchronized
    fun getComponent(): C {
        if (component == null) {
            component = initComponent()
        }

        return component ?: throw RuntimeException("Component not initialized")
    }

}