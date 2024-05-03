package com.example.daggerdependencyinjection

import dagger.BindsInstance
import dagger.Component

@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    fun inject(mainActivity: MainActivity)

    // Factory is used to create objects
    // Wre are telling dagger that whenever you use this module, make it using following factory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount:Int):UserRegistrationComponent
    }
}