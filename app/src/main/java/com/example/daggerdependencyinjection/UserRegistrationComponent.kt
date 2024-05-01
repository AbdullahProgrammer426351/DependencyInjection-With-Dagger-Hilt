package com.example.daggerdependencyinjection

import dagger.Component

@Component
interface UserRegistrationComponent {
    // suppose we need 50 dependencies, then we have to create 50 functions in this class if
    // we use our old approach
   // instead of creating custom methods, we have another smart way to do same task like this.
    fun inject(mainActivity: MainActivity)
}