package com.example.daggerdependencyinjection

import android.util.Log
import com.example.daggerdependencyinjection.MainActivity.Companion.TAG
import javax.inject.Inject

class UserRepository @Inject constructor() {
    fun saveUser(email:String, password:String){
        Log.d(TAG, "User saved in DB with email '$email' and password '$password'")
    }
}